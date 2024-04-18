package application;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TableScreen {
	Stage stage3;
private Button mainPage;
private Label labeltop;
private BorderPane bordertable = new BorderPane();
private TableView<HuffTable> huftable;

  TableScreen(){
	  mainPage= new Button(" MainPage ");
	  mainPage.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC,18));
	  mainPage.setMinSize(150, 50);
	  mainPage.setStyle(
	            
				 "-fx-background-radius: 10em; " +
			                "-fx-min-width: 200px; " +
			                "-fx-min-height: 50px; " +
			                "-fx-max-width: 250px; " +
			                "-fx-max-height: 150px; " +"-fx-background-color: white;" 
	    );
	  
	  labeltop = new Label("Table Of Huffman Codes Before And After Compress !");
	  labeltop.setTextFill(Color.WHITE);
	  labeltop.setFont(Font.font("BankGothic LT BT", FontWeight.BOLD, FontPosture.ITALIC,40));
	  labeltop.setMinWidth(100);
	  
	  huftable = new TableView<HuffTable>();
	  
		 TableColumn<HuffTable, String> asciicolumn = new TableColumn<HuffTable, String>("ASCII CHARACTER ");
			asciicolumn.setCellValueFactory(new PropertyValueFactory<HuffTable, String>("ASCII"));
			asciicolumn.setMinWidth(200);
		
			
			 TableColumn<HuffTable, String> hufcolumn = new TableColumn<HuffTable, String>(" Huffman Code ");
			 hufcolumn.setCellValueFactory(new PropertyValueFactory<HuffTable, String>("huffmanCode"));
			 hufcolumn.setMinWidth(200);
				
			 
			 TableColumn<HuffTable, Integer> lengthcolumn = new TableColumn<HuffTable, Integer>(" Length Code ");
			 lengthcolumn.setCellValueFactory(new PropertyValueFactory<HuffTable, Integer>("Length"));
			 lengthcolumn.setMinWidth(200);
			 
			 TableColumn<HuffTable, Integer> freqcolumn = new TableColumn<HuffTable, Integer>(" Frequencey ");
			freqcolumn.setCellValueFactory(new PropertyValueFactory<HuffTable, Integer>("frequencey"));
			freqcolumn.setMinWidth(200);
			
			TableColumn<HuffTable, Integer> byteccolumn = new TableColumn<HuffTable, Integer>(" Byte Code ");
			 byteccolumn.setCellValueFactory(new PropertyValueFactory<HuffTable, Integer>("bytecode"));
			 byteccolumn.setMinWidth(200);
	        
			 huftable.getColumns().addAll(asciicolumn ,byteccolumn,hufcolumn,lengthcolumn,freqcolumn);

			 huftable.setStyle("-fx-border-color:black; "+ "-fx-border-width:5;"+"-fx-font-family: Arial;"
			 +"-fx-font-size: 14px;");
			 
			 huftable.setMaxHeight(1000);
			 huftable.setMaxWidth(1000);
	
			 Image m = new Image("file:///C:/Users/Ehab/eclipse-workspace/DataProject1/src/backgroundproj2.jpeg");
			 ImageView mg = new ImageView(m);
			 mg.setFitHeight(600);
			 mg.setFitWidth(1250);
			 bordertable.getChildren().add(mg);
			 bordertable.setTop(labeltop);
			 bordertable.setCenter(huftable);
			 bordertable.setAlignment(huftable, Pos.CENTER);
			 bordertable.setBottom(mainPage);
			 bordertable.setAlignment(mainPage, Pos.CENTER);
    }

public Button getMainPage() {
	return mainPage;
}

public Label getLabeltop() {
	return labeltop;
}

public BorderPane getBordertable() {
	return bordertable;
}

public TableView<HuffTable> getHuftable() {
	return huftable;
}

public void setMainPage(Button mainPage) {
	this.mainPage = mainPage;
}

public void setLabeltop(Label labeltop) {
	this.labeltop = labeltop;
}

public void setBordertable(BorderPane bordertable) {
	this.bordertable = bordertable;
}

public void setHuftable(TableView<HuffTable> huftable) {
	this.huftable = huftable;
}

  
			      
  } 