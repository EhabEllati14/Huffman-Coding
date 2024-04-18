package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

   public class SizeScreen {
	   Stage stage4;
   public Stage getStage4() {
		return stage4;
	}







	public Button getMainPage() {
		return mainPage;
	}







	public Label getLabelsizebefore() {
		return labelsizebefore;
	}







	public Label getLabelsizeafter() {
		return labelsizeafter;
	}







	public Label getLabelbefore() {
		return labelbefore;
	}







	public Label getLabelafter() {
		return labelafter;
	}







	public BorderPane getBp() {
		return Bp;
	}







	public GridPane getGrid() {
		return grid;
	}







	public void setStage4(Stage stage4) {
		this.stage4 = stage4;
	}







	public void setMainPage(Button mainPage) {
		this.mainPage = mainPage;
	}







	public void setLabelsizebefore(Label labelsizebefore) {
		this.labelsizebefore = labelsizebefore;
	}







	public void setLabelsizeafter(Label labelsizeafter) {
		this.labelsizeafter = labelsizeafter;
	}







	public void setLabelbefore(Label labelbefore) {
		this.labelbefore = labelbefore;
	}







	public void setLabelafter(Label labelafter) {
		this.labelafter = labelafter;
	}







	public void setBp(BorderPane bp) {
		Bp = bp;
	}







	public void setGrid(GridPane grid) {
		this.grid = grid;
	}







private Button mainPage;
   private Label labelsizebefore,labelsizeafter,labelbefore,labelafter;
   private BorderPane Bp = new BorderPane();
    private GridPane grid = new GridPane();
    
    

    
    
    
    
    SizeScreen(){
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
   	  
   	labelsizebefore= new Label(" Size Before Compress ");
   	labelsizebefore.setFont(Font.font("BankGothic LT BT", FontWeight.BOLD, FontPosture.ITALIC, 20));
   	labelsizebefore.setTextFill(javafx.scene.paint.Color.WHITE);
   	
   	labelsizeafter= new Label(" Size After Compress ");
   	labelsizeafter.setFont(Font.font("BankGothic LT BT", FontWeight.BOLD, FontPosture.ITALIC, 20));
   	labelsizeafter.setTextFill(javafx.scene.paint.Color.WHITE);
   	
   	labelbefore= new Label();
   	labelbefore.setFont(Font.font("BankGothic LT BT", FontWeight.BOLD, FontPosture.ITALIC, 20));
   	labelbefore.setTextFill(javafx.scene.paint.Color.WHITE);
   	
   	labelafter= new Label();
   	labelafter.setFont(Font.font("BankGothic LT BT", FontWeight.BOLD, FontPosture.ITALIC, 20));
   	labelafter.setTextFill(javafx.scene.paint.Color.WHITE);
   	
   	grid.add(labelsizebefore, 0, 0);
   	grid.add(labelsizeafter, 0, 1);
   	grid.add(labelbefore, 1, 0);
   	grid.add(labelafter, 1, 1);
   	grid.setVgap(30);
   	grid.setHgap(30);
   	 
   	Image m = new Image("file:///C:/Users/Ehab/eclipse-workspace/DataProject1/src/backgroundproj2.jpeg");
	ImageView mg = new ImageView(m);
	 mg.setFitHeight(600);
	 mg.setFitWidth(1250);
	 Bp.getChildren().add(mg);
    Bp.setCenter(grid);
    Bp.setAlignment(grid, Pos.CENTER);
    Bp.setBottom(mainPage);
    Bp.setAlignment(mainPage,Pos.CENTER);
    
 
    }
}
