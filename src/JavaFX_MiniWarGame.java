import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFX_MiniWarGame extends Application {
    Player[] kumpulan_pemain = new Player[2];
    Scene scene_1, scene_2, scene_3, scene_4, scene_5, scene_6;
    public static void main(String[] args) {
        launch(args);
    }

    // --------------------------------------------------------------------------------IF FUNCTION & ANOTHER BOX--------------------------------------------------------------------------------------
    String tepat_1(int masukan_1, int angka_acak_1){
        if (masukan_1 == angka_acak_1) {
            double nyawa_berkurang = kumpulan_pemain[0].perang.attPower;
            kumpulan_pemain[1].nyawa -= nyawa_berkurang;
            return "Serangan anda tepat sasaran!";
        } else if (masukan_1 == angka_acak_1 + 1 || masukan_1 == angka_acak_1 - 1){
            double nyawa_berkurang = kumpulan_pemain[0].perang.attPower * 0.5;
            kumpulan_pemain[1].nyawa -= nyawa_berkurang;
            return "Serangan anda menyerempet lawan!";
        } else {
            return "Serangan anda meleset !";
        }
    }

    String tepat_2(int masukan_2, int angka_acak_2){
        if (masukan_2 == angka_acak_2) {
            double nyawa_berkurang = kumpulan_pemain[1].perang.attPower;
            kumpulan_pemain[0].nyawa -= nyawa_berkurang;
            return "Serangan anda tepat sasaran!";
        } else if (masukan_2 == angka_acak_2 + 1 || masukan_2 == angka_acak_2 - 1){
            double nyawa_berkurang = kumpulan_pemain[1].perang.attPower * 0.5;
            kumpulan_pemain[0].nyawa -= nyawa_berkurang;
            return "Serangan anda menyerempet lawan!";
        } else {
            return "Serangan anda meleset !";
        }
    }

    String ketentuan(Player[] kumpulan_pemain){
        if (kumpulan_pemain[0].nyawa <= 0){
            return "Pertarungan selesai, pemenangnya adalah " + kumpulan_pemain[1].nama + "!";
        } else if (kumpulan_pemain[1].nyawa  <= 0){
            return "Pertarungan selesai, pemenangnya adalah " + kumpulan_pemain[0].nama + "!";
        } else {
            return "Sisa nyawa " + kumpulan_pemain[0].nama + " dironde ini adalah " + kumpulan_pemain[0].nyawa + "\n" + "Sisa nyawa " + kumpulan_pemain[1].nama + " dironde ini adalah " + kumpulan_pemain[1].nyawa;
        }
    }

    boolean true_false_bool(Player[] kumpulan_pemain){
        if (ketentuan(kumpulan_pemain).equals("Pertarungan selesai, pemenangnya adalah " + kumpulan_pemain[1].nama + "!")) {
            return false;
        } else if (ketentuan(kumpulan_pemain).equals("Pertarungan selesai, pemenangnya adalah " + kumpulan_pemain[0].nama + "!")) {
            return false;
        } else {
            return true;
        }
    }

    boolean turn_around(Player[] kumpulan_pemain){
        if (true_false_bool(kumpulan_pemain) == false) {
            return true;
        } else {
            return false;
        }
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public void start(Stage primaryStage) throws Exception {
    
    // --------------------------------------------------------------------------------SCENE 1--------------------------------------------------------------------------------------
    VBox layout_1 = new VBox();

    Label label_1 = new Label("Selamat Datang di MiniWarGame!");
    label_1.setId("bold-label");

    Button lanjut_scene = new Button("Mulai!");
    lanjut_scene.setOnAction(e -> primaryStage.setScene(scene_2));
    layout_1.setSpacing(50);
    layout_1.getChildren().addAll(label_1, lanjut_scene);
    layout_1.setAlignment(Pos.CENTER);

    Scene scene_1 = new Scene(layout_1, 400, 300);
    scene_1.getStylesheets().add("scene_1.css");

    primaryStage.setScene(scene_1);
    primaryStage.show();
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    // --------------------------------------------------------------------------------SCENE 2--------------------------------------------------------------------------------------
    Label textUsername = new Label("Masukan Username Player 1!");
    textUsername.setId("bold-label");
    TextField username = new TextField();
    username.setAlignment(Pos.CENTER);
    username.setId("ganti_warna");

    Label textSelectWeapon = new Label("Player 1 Pilih Angka 1 - 3 Untuk Memilih Senjata!");
    textSelectWeapon.setId("bold-label");
    TextField selectWeapon = new TextField();
    selectWeapon.setAlignment(Pos.CENTER);
    selectWeapon.setId("ganti_warna");

    Label textSelectArmor = new Label("Player 1 Pilih Angka 1 - 3 Untuk Memilih Armor!");
    textSelectArmor.setId("bold-label");
    TextField selectArmor = new TextField();
    selectArmor.setAlignment(Pos.CENTER);
    selectArmor.setId("ganti_warna");

    Button choose = new Button("Choose!");
    
    choose.setOnAction(e -> {
        if (Integer.parseInt(selectWeapon.getText()) > 0 && Integer.parseInt(selectWeapon.getText()) < 4){
            if (Integer.parseInt(selectArmor.getText()) > 0 && Integer.parseInt(selectArmor.getText()) < 4){
                Player pemain_1 = new Player(username.getText(), 100);
                Senjata weapon_1 = new Senjata(Integer.parseInt(selectWeapon.getText()));
                Armor armor_1 = new Armor(Integer.parseInt(selectArmor.getText()));
            
                pemain_1.pakaiSenjata(weapon_1);
                pemain_1.pakaiArmor(armor_1);
    
                kumpulan_pemain[0] = pemain_1;
    
                primaryStage.setScene(scene_3);
            } else {
                Alert gaboleh = new Alert(AlertType.ERROR);
                gaboleh.setContentText("Inputan armor anda tidak sesuai!");
                gaboleh.showAndWait();
                primaryStage.setScene(scene_2);
            }
        } else {
            Alert gaboleh = new Alert(AlertType.ERROR);
            gaboleh.setContentText("Inputan senjata anda tidak sesuai!");
            gaboleh.showAndWait();
            primaryStage.setScene(scene_2);
        }
    });

    VBox layout_2 = new VBox();
    layout_2.setPadding(new Insets(20, 20, 20, 20));
    layout_2.setSpacing(20);
    layout_2.setAlignment(Pos.CENTER);
    layout_2.getChildren().addAll(textUsername, username, textSelectWeapon, selectWeapon, textSelectArmor, selectArmor, choose);

    scene_2 = new Scene(layout_2, 350, 350);
    scene_2.getStylesheets().add("scene_2.css");
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    // --------------------------------------------------------------------------------SCENE 3--------------------------------------------------------------------------------------
    Label textUsername_2 = new Label("Masukan Username Player 2!");
    textUsername_2.setId("bold-label-2");
    TextField username_2 = new TextField();
    username_2.setAlignment(Pos.CENTER);
    username_2.setId("ganti_warna");

    Label textSelectWeapon_2 = new Label("Player 2 Pilih Angka 1 - 3 Untuk Memilih Senjata!");
    textSelectWeapon_2.setId("bold-label-2");
    TextField selectWeapon_2 = new TextField();
    selectWeapon_2.setAlignment(Pos.CENTER);
    selectWeapon_2.setId("ganti_warna");

    Label textSelectArmor_2 = new Label("Player 2 Pilih Angka 1 - 3 Untuk Memilih Senjata!");
    textSelectArmor_2.setId("bold-label-2");
    TextField selectArmor_2 = new TextField();
    selectArmor_2.setAlignment(Pos.CENTER);
    selectArmor_2.setId("ganti_warna");

    Button choose_2 = new Button("Choose!");
    choose_2.setOnAction(e -> {
        if (Integer.parseInt(selectWeapon_2.getText()) > 0 && Integer.parseInt(selectWeapon_2.getText()) < 4){
            if (Integer.parseInt(selectArmor_2.getText()) > 0 && Integer.parseInt(selectArmor_2.getText()) < 4){
                Player pemain_2 = new Player(username_2.getText(), 100);
                Senjata weapon_2 = new Senjata(Integer.parseInt(selectWeapon_2.getText()));
                Armor armor_2 = new Armor(Integer.parseInt(selectArmor_2.getText()));
            
                pemain_2.pakaiSenjata(weapon_2);
                pemain_2.pakaiArmor(armor_2);

                kumpulan_pemain[1] = pemain_2;

                // To Scene 4
                Scene scene_4 = getScene4(primaryStage, kumpulan_pemain);
                primaryStage.setScene(scene_4);
            } else {
                Alert gaboleh = new Alert(AlertType.ERROR);
                gaboleh.setContentText("Inputan armor anda tidak sesuai!");
                gaboleh.showAndWait();
                primaryStage.setScene(scene_3);
            }
        } else {
            Alert gaboleh = new Alert(AlertType.ERROR);
            gaboleh.setContentText("Inputan senjata anda tidak sesuai!");
            gaboleh.showAndWait();
            primaryStage.setScene(scene_3);
        }
    });

    VBox layout_3 = new VBox();
    layout_3.setPadding(new Insets(20, 20, 20, 20));
    layout_3.setSpacing(20);
    layout_3.setAlignment(Pos.CENTER);
    layout_3.getChildren().addAll(textUsername_2, username_2, textSelectWeapon_2, selectWeapon_2, textSelectArmor_2, selectArmor_2, choose_2);

    scene_3 = new Scene(layout_3, 350, 350);
    scene_3.getStylesheets().add("scene_2.css");
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    }

    // --------------------------------------------------------------------------------SCENE 4--------------------------------------------------------------------------------------
    Scene getScene4(Stage primaryStage, Player[] kumpulan_pemain){
        VBox layout_4 = new VBox();
        
        Label identitas_1 = new Label("PLAYER 1");
        identitas_1.setId("bold-label-player1");
        Label identitas_nama_1 = new Label("Nama : " + kumpulan_pemain[0].nama);
        identitas_nama_1.setId("bold-label-1");
        Label identitas_nyawa_1 = new Label("Nyawa : " + kumpulan_pemain[0].nyawa);
        identitas_nyawa_1.setId("bold-label-1");
        Label identitas_senjata_1 = new Label(kumpulan_pemain[0].perang.display());
        identitas_senjata_1.setId("bold-label-1");
        Label identitas_armor_1 = new Label(kumpulan_pemain[0].defense.display());
        identitas_armor_1.setId("bold-label-1");

        Label pembatas = new Label("====================================");
        pembatas.setId("pembatas");

        Label identitas_2 = new Label("PLAYER 2");
        identitas_2.setId("bold-label-player2");
        Label identitas_nama_2 = new Label("Nama : " + kumpulan_pemain[1].nama);
        identitas_nama_2.setId("bold-label-2");
        Label identitas_nyawa_2 = new Label("Nyawa : " + kumpulan_pemain[1].nyawa);
        identitas_nyawa_2.setId("bold-label-2");
        Label identitas_senjata_2 = new Label(kumpulan_pemain[1].perang.display());
        identitas_senjata_2.setId("bold-label-2");
        Label identitas_armor_2 = new Label(kumpulan_pemain[1].defense.display());
        identitas_armor_2.setId("bold-label-2");

        Button lanjut = new Button("Bertempur!");
        lanjut.setOnAction(e -> {
            Scene scene_5 = getScene5(primaryStage, kumpulan_pemain);
            primaryStage.setScene(scene_5);
        });
        
        layout_4.setAlignment(Pos.CENTER);
        layout_4.setSpacing(10);
        layout_4.getChildren().addAll(
            identitas_1,
            identitas_nama_1,
            identitas_nyawa_1,
            identitas_senjata_1,
            identitas_armor_1,
            pembatas,
            identitas_2,
            identitas_nama_2,
            identitas_nyawa_2,
            identitas_senjata_2,
            identitas_armor_2,
            lanjut
        );
        
        Scene scene = new Scene(layout_4, 500, 500);
        scene.getStylesheets().add("scene_4.css");
        return scene;
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    // --------------------------------------------------------------------------------SCENE 5--------------------------------------------------------------------------------------
    Scene getScene5(Stage primaryStage, Player[] kumpulan_pemain){
        VBox layout_5 = new VBox();

        Random random = new Random();

        // Random angka
        int angka_acak_1 = random.nextInt(10) + 1;
        int angka_acak_2 = random.nextInt(10) + 1;

        // Masukan angka pemain 1 untuk menyerang
        Label input_kata_1 = new Label(kumpulan_pemain[0].nama + " silahkan memilih angka dari 1 - 10 : ");
        input_kata_1.setId("bold-label");
        TextField input_1 = new TextField();
        input_1.setAlignment(Pos.CENTER);

        // Masukan angka pemain 2 untuk menyerang
        Label input_kata_2 = new Label(kumpulan_pemain[1].nama + " silahkan memilih angka dari 1 - 10 : ");
        input_kata_2.setId("bold-label-2");
        TextField input_2 = new TextField();
        input_2.setAlignment(Pos.CENTER);
        
        
        Button pilih_1 = new Button("Pilih!");
        pilih_1.setOnAction(e -> {
            int masukan_1 = Integer.parseInt(input_1.getText());
            int masukan_2 = Integer.parseInt(input_2.getText());
            if (masukan_1 > 0 && masukan_1 < 11){
                if (masukan_2 > 0 && masukan_2 < 11){
                    Scene scene_6 = getScene6(primaryStage, kumpulan_pemain, tepat_1(masukan_1, angka_acak_1), tepat_2(masukan_2, angka_acak_2));
                    primaryStage.setScene(scene_6);
                } else {
                    Alert gaboleh = new Alert(AlertType.ERROR);
                    gaboleh.setContentText("Inputan serangan " + kumpulan_pemain[1].nama + " tidak sesuai!");
                    gaboleh.showAndWait();
                }
            } else {
                Alert gaboleh = new Alert(AlertType.ERROR);
                gaboleh.setContentText("Inputan serangan " + kumpulan_pemain[0].nama + " tidak sesuai!");
                gaboleh.showAndWait();
            }
        }); 

        layout_5.setPadding(new Insets(20, 20, 20, 20));
        layout_5.getChildren().addAll(input_kata_1, input_1, input_kata_2, input_2, pilih_1);
        layout_5.setAlignment(Pos.CENTER);
        layout_5.setSpacing(10);

        Scene scene_5 = new Scene(layout_5, 350, 300);
        scene_5.getStylesheets().add("scene_5.css");
        return scene_5;
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    // --------------------------------------------------------------------------------SCENE 6--------------------------------------------------------------------------------------
    Scene getScene6(Stage primaryStage, Player[] kumpulan_pemain, String satu, String dua){
        VBox layout_6 = new VBox();

        Label kondisi_1 = new Label("Serangan " + kumpulan_pemain[0].nama + " : " + satu);
        kondisi_1.setId("bold-label-1");
        Label kondisi_2 = new Label("Serangan " + kumpulan_pemain[1].nama + " : " + dua);
        kondisi_2.setId("bold-label-2");

        Label pembatas = new Label("=============================");
        pembatas.setId("pembatas");

        Label kondisi_3 = new Label(ketentuan(kumpulan_pemain));
        kondisi_3.setId("bold-label-3");

        Button balik = new Button("Lanjutkan");
        balik.setDisable(turn_around(kumpulan_pemain));
        balik.setOnAction(e -> {
            Scene scene_5 = getScene5(primaryStage, kumpulan_pemain);
            primaryStage.setScene(scene_5);
        });

        Button ulang = new Button("Main Lagi");
        ulang.setDisable(true_false_bool(kumpulan_pemain));
        ulang.setOnAction(e -> {
            primaryStage.setScene(scene_2);
        });

        Button keluar = new Button("Keluar");
        keluar.setDisable(true_false_bool(kumpulan_pemain)); 
        keluar.setOnAction(e -> {
            primaryStage.close();
        });

        layout_6.getChildren().addAll(kondisi_1, kondisi_2, pembatas, kondisi_3, balik, ulang, keluar);
        layout_6.setAlignment(Pos.CENTER);
        layout_6.setSpacing(10);

        Scene scene = new Scene(layout_6, 400, 300);
        scene.getStylesheets().add("scene_6.css");
        return scene;

    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
}
