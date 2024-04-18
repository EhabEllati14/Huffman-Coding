package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StartPage {
	Stage stage2;
	private Label chooselabel;
    private Button filechooser,compress,decomp,table,size,mainp;
    private TextField text;
    private BorderPane border = new BorderPane();
    private VBox vbox = new VBox(15);
    private HBox hbox= new HBox(10);
    
    StartPage(){
    	
    	chooselabel = new Label("Please Choose the File To Compress Or Decompress It !! ");
    	chooselabel.setTextFill(Color.WHITE);
		chooselabel.setFont(Font.font("BankGothic LT BT", FontWeight.BOLD, FontPosture.ITALIC,40));
		chooselabel.setMinWidth(100);
		
		filechooser= new Button(" File Chooser ");
		filechooser.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		filechooser.setMinSize(150, 50);
		filechooser.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 200px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 250px; " +
			                "-fx-max-height: 150px; " +"-fx-background-color: white;" 
	    );
		
		compress= new Button(" Compress ");
		compress.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		compress.setMinSize(150, 50);
		compress.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 200px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 250px; " +
			                "-fx-max-height: 150px; " +"-fx-background-color: white;" 
	    );
		
		decomp= new Button(" Decompress ");
		decomp.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		decomp.setMinSize(150, 50);
		decomp.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 200px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 250px; " +
			                "-fx-max-height: 150px; " +"-fx-background-color: white;" 
	    );
		
		table= new Button(" Table ");
		table.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		table.setMinSize(150, 50);
		table.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 200px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 250px; " +
			                "-fx-max-height: 150px; " +"-fx-background-color: white;" 
	    );
		
		size= new Button(" Size ");
		size.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		size.setMinSize(150, 50);
		size.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 200px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 250px; " +
			                "-fx-max-height: 150px; " +"-fx-background-color: white;" 
	    );
		
		mainp= new Button(" MainPage ");
		mainp.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		mainp.setMinSize(150, 50);
		mainp.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 200px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 250px; " +
			                "-fx-max-height: 150px; " +"-fx-background-color: white;" 
	    );
		
		text= new TextField();
		text.setFont(Font.font("BankGothic LT BT", FontWeight.BOLD, FontPosture.ITALIC, 20));
		text.setMinWidth(300);
		text.setMinHeight(40);
		
		hbox.getChildren().addAll(text,filechooser);
		hbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox,compress,decomp,table,size);
		vbox.setAlignment(Pos.CENTER);
		Image m = new Image("file:///C:/Users/Ehab/eclipse-workspace/DataProject1/src/backgroundproj2.jpeg");
		ImageView mg= new ImageView(m);
		 mg.setFitHeight(600);
		 mg.setFitWidth(1250);
		border.getChildren().add(mg);
		border.setTop(chooselabel);
		border.setCenter(vbox);
		border.setBottom(mainp);
		border.setAlignment(mainp, Pos.CENTER);
				
		
		
		
		
    }

	public Stage getStage2() {
		return stage2;
	}

	public Label getChooselabel() {
		return chooselabel;
	}

	public Button getFilechooser() {
		return filechooser;
	}

	public Button getCompress() {
		return compress;
	}

	public Button getDecomp() {
		return decomp;
	}

	public Button getTable() {
		return table;
	}

	public Button getSize() {
		return size;
	}

	public Button getMainp() {
		return mainp;
	}

	public TextField getText() {
		return text;
	}

	public BorderPane getBorder() {
		return border;
	}

	public VBox getVbox() {
		return vbox;
	}

	public HBox getHbox() {
		return hbox;
	}

	public void setStage2(Stage stage2) {
		this.stage2 = stage2;
	}

	public void setChooselabel(Label chooselabel) {
		this.chooselabel = chooselabel;
	}

	public void setFilechooser(Button filechooser) {
		this.filechooser = filechooser;
	}

	public void setCompress(Button compress) {
		this.compress = compress;
	}

	public void setDecomp(Button decomp) {
		this.decomp = decomp;
	}

	public void setTable(Button table) {
		this.table = table;
	}

	public void setSize(Button size) {
		this.size = size;
	}

	public void setMainp(Button mainp) {
		this.mainp = mainp;
	}

	public void setText(TextField text) {
		this.text = text;
	}

	public void setBorder(BorderPane border) {
		this.border = border;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}

	public void setHbox(HBox hbox) {
		this.hbox = hbox;
	}
    
    
 
 
}
