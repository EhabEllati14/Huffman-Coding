package application;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainPage {
	Stage stage1;
 private HBox hboxmain = new HBox(80);
 private Button close , information ,start;
 private Label title;
 private Group group = new Group();
 
 MainPage(){
	 close = new Button(" Close ");
		close.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		close.setMinSize(150, 50);
		close.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 200px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 250px; " +
			                "-fx-max-height: 150px; " +"-fx-background-color: white;" 
	    );
		
		information = new Button(" Information ");
		information.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		information.setMinSize(150, 50);
		information.setStyle(
		            
					 "-fx-background-radius: 10em; " +
				                "-fx-min-width: 200px; " +
				                "-fx-min-height: 50px; " +
				                "-fx-max-width: 250px; " +
				                "-fx-max-height: 150px; " +"-fx-background-color: white;" 
		    );
		
		start = new Button(" Start ");
		start.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
		start.setMinSize(150, 50);
		start.setStyle(
		            
					 "-fx-background-radius: 10em; " +
				                "-fx-min-width: 200px; " +
				                "-fx-min-height: 50px; " +
				                "-fx-max-width: 250px; " +
				                "-fx-max-height: 150px; " +"-fx-background-color: white;" 
		    );
		title = new Label("  Compress And Decompress Files   ");
		title.setStyle(
	    		"-fx-background-color: derive(#61a2b1,1.7);"+"-fx-background-color:black;" +
	            "-fx-background-insets: 0.5;" +
	            "-fx-padding: 5;" +
	            "-fx-background-radius: 100em; " +
	            "-fx-min-width: 950px; " +
	            "-fx-min-height: 40px; " +
	            "-fx-max-width: 600px; " +
	            "-fx-border-width: 1;" +
	            "-fx-border-radius: 5;" +
	            "-fx-fill: white;" 
	    );


	  
		title.setTextFill(Color.WHITE.brighter().brighter());
		title.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 60));
		title.setLayoutX(150);
		title.setLayoutY(200);
		hboxmain.getChildren().addAll(information,start  ,close);
		hboxmain.setAlignment(Pos.CENTER);
		hboxmain.setLayoutX(250);
		hboxmain.setLayoutY(400);
		Image m = new Image("file:///C:/Users/Ehab/eclipse-workspace/DataProject1/src/backgroundproj2.jpeg");
		ImageView mg = new ImageView(m);
		 mg.setFitHeight(600);
		 mg.setFitWidth(1250);
		 group.getChildren().addAll(mg,title,hboxmain);
 }

public Stage getStage1() {
	return stage1;
}

public HBox getHboxmain() {
	return hboxmain;
}

public Button getClose() {
	return close;
}

public Button getInformation() {
	return information;
}

public Button getStart() {
	return start;
}

public Label getTitle() {
	return title;
}

public Group getGroup() {
	return group;
}

public void setStage1(Stage stage1) {
	this.stage1 = stage1;
}

public void setHboxmain(HBox hboxmain) {
	this.hboxmain = hboxmain;
}

public void setClose(Button close) {
	this.close = close;
}

public void setInformation(Button information) {
	this.information = information;
}

public void setStart(Button start) {
	this.start = start;
}

public void setTitle(Label title) {
	this.title = title;
}

public void setGroup(Group group) {
	this.group = group;
}
 
 
 }
