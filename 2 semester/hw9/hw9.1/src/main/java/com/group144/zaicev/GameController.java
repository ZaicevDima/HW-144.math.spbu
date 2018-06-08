package com.group144.zaicev;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
 * Class for play in tic tac toe
 */
public class GameController extends Application {

    private static Button serverButton;
    private static Button clientButton;
    private static Button connect;
    private static TextField ipAddress;
    private static GridPane connectScreen = new GridPane();
    private Scene scene = new Scene(connectScreen, 500, 300);

    private boolean isMyMove = false;
    private int amountMovesFirstPlayer = 0;

    private static Button[][] buttons = new Button[3][3];

    private volatile Game game;
    private final ExecutorService executor;

    /**
     * constructor
     */
    public GameController() {
        executor = Executors.newSingleThreadExecutor();
    }

    /**
     * create start menu
     */
    private static void initialize() {
        connectScreen.setPadding(new Insets(25, 25, 25, 25));
        connectScreen.setHgap(25);
        connectScreen.setVgap(15);

        serverButton = new Button();
        serverButton.setText("server button");
        serverButton.setPrefSize(230, connectScreen.getHeight() / 5);

        clientButton = new Button();
        clientButton.setText("client button");
        clientButton.setPrefSize(230, connectScreen.getHeight() / 5);

        Label massege = new Label("IP address: ");

        ipAddress = new TextField();
        ipAddress.setDisable(true);

        connect = new Button("connect");
        connect.setPrefSize(150, 40);
        connect.setDisable(true);

        connectScreen.add(serverButton, 0, 0);
        connectScreen.add(clientButton, 1, 0);
        connectScreen.add(massege, 0, 1);

        connectScreen.add(connect, 1, 2);
        GridPane.setHalignment(connect, HPos.CENTER);
        GridPane.setValignment(connect, VPos.CENTER);

        connectScreen.add(ipAddress, 0, 2);
    }

    /**
     * sens the command other player
     *
     * @param command your command
     */
    private void processCommand(String command) {
        game.send(command);
    }

    /**
     * action on buttons
     *
     * @param symbol "X" if the client move, else "O";
     */
    private void pressButtons(String symbol) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int finalI = i;
                int finalJ = j;
                buttons[i][j].setOnAction(event -> {
                    if (buttons[finalI][finalJ].getText().equals("") && isMyMove) {
                        amountMovesFirstPlayer++;
                        buttons[finalI][finalJ].setText(symbol);
                        buttons[finalI][finalJ].setText(symbol);
                        processCommand(finalI + " " + finalJ);
                        isMyMove = !isMyMove;
                        if (CheckingWin.isWinner(getValueFromButtons())) {
                            exitWindow(symbol, " win");
                        }

                        if ((amountMovesFirstPlayer == 5) && (!CheckingWin.isWinner(getValueFromButtons()))) {
                            exitWindow(symbol, "Draw");
                        }
                    }
                });
            }
        }
    }

    /**
     * Show dialog window, when the game ends
     *
     * @param state  state game (win, lose or draw)
     * @param symbol user symbol
     */
    private void exitWindow(String symbol, String state) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.CLOSE);
        alert.setTitle("exit");
        alert.setHeaderText(null);
        if (state.equals("Draw")) {
            alert.setContentText(state);
        } else {
            alert.setContentText(symbol + state);
        }
        alert.showAndWait().ifPresent(response -> System.exit(1));
    }

    /**
     * changes player playing field
     *
     * @param symbol symbol of the opposite player
     */
    private void changeField(String symbol) {
        executor.execute(() -> {
            game.send("hello");

            String result = "";
            while (!result.equals("exit")) {
                result = game.receive();
                if (result == null) {
                    return;
                }
                String finalResult = result;
                Platform.runLater(() -> {
                    if (finalResult.matches("\\d \\d")) {
                        isMyMove = true;
                        int[] coordinates = Stream.of(finalResult.trim().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                        buttons[coordinates[0]][coordinates[1]].setText(symbol);
                        if (CheckingWin.isWinner(getValueFromButtons())) {
                            exitWindow(symbol.equals("X") ? "O" : "X", " lose");
                        }

                        if ((amountMovesFirstPlayer == 4) && (symbol.equals("X"))
                                && (!CheckingWin.isWinner(getValueFromButtons()))) {
                            exitWindow(symbol, "Draw");
                        }
                    }
                });
            }
        });
    }

    /**
     * starts game
     *
     * @param primaryStage main stage
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Connecting");

        initialize();

        serverButtonAction();

        clientButton.setOnAction(event -> {
            clientButton.setDisable(true);
            serverButton.setDisable(true);
            connect.setDisable(false);
            ipAddress.setDisable(false);
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        connectButtonAction();
    }

    /**
     * actions on the server buttons
     */
    private void serverButtonAction() {
        serverButton.setOnAction(event -> {
            clientButton.setDisable(true);

            InetAddress thisIp = null;

            try {
                thisIp = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Can't get IP", ButtonType.CLOSE);
                alert.setHeaderText(null);
                alert.showAndWait();
                System.exit(1);
            }

            Label ip = new Label("Your IP address: " + thisIp.getHostAddress());
            connectScreen.add(ip, 0, 4);
            serverButton.setDisable(true);

            gameForServer();
        });
    }

    /**
     * realise game for server
     */
    private void gameForServer() {
        game = new ServerGame();
        GridPane serverField = new GridPane();
        Stage serverWindow = new Stage();
        StackPane serverStackPane = new StackPane();

        serverField = createField(serverField);
        serverStackPane.getChildren().add(serverField);
        Scene serverScene = new Scene(serverStackPane, 300, 300);

        serverWindow.setTitle("Server Window");
        serverWindow.setScene(serverScene);
        serverWindow.show();

        changeField("X");
        pressButtons("O");
    }

    /**
     * actions on the connect button
     */
    private void connectButtonAction() {
        connect.setOnAction(event -> {
            String text = ipAddress.getText();

            try {
                if (!InetAddress.getByName(text).isReachable(1000)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Wrong IP", ButtonType.CLOSE);
                    alert.setHeaderText(null);
                    alert.setTitle("error");
                    alert.showAndWait();
                    System.exit(1);
                }
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,
                        "Couldn't get I/O for the connection to: " + text, ButtonType.CLOSE);
                alert.setHeaderText(null);
                alert.setTitle("error");
                alert.showAndWait();
                System.exit(1);
            }
            game = new ClientGame(text);
            gameForClient();
        });
    }

    /**
     * realise game for client
     */
    private void gameForClient() {
        Stage clientWindow = new Stage();
        GridPane clientField = new GridPane();

        clientField.setMinSize(300, 300);
        clientField = GameController.createField(clientField);

        StackPane clientStackPane = new StackPane();
        clientStackPane.getChildren().add(clientField);
        Scene clientScene = new Scene(clientStackPane, 300, 300);

        clientWindow.setTitle("Client Window");
        clientWindow.setScene(clientScene);
        clientWindow.show();

        isMyMove = true;

        changeField("O");
        pressButtons("X");
    }

    /**
     * creates playing field
     *
     * @param gridPane old field
     * @return new playing field
     */
    private static GridPane createField(GridPane gridPane) {
        gridPane.getColumnConstraints().add(new ColumnConstraints(100));
        gridPane.getRowConstraints().add(new RowConstraints(100));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Button("");
                buttons[i][j].setPrefSize(100, 100);
                gridPane.add(buttons[i][j], i, j);
            }
        }
        return gridPane;
    }

    /**
     * returns values from buttons
     */
    private String[][] getValueFromButtons() {
        String[][] valueFromButtons = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                valueFromButtons[i][j] = buttons[i][j].getText();
            }
        }
        return valueFromButtons;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
