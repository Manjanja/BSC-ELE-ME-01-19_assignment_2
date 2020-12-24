import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FeedCalculator extends Application
{
    static TextArea textOutPut;
    static TextField  textfieldForMaize;
    static TextField  textfieldForSoya;
    static TextField  textfieldForgnuts;
    static TextField  textfieldForSalt;
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
       
           
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(getVBox(), 300, 450);
        
        primaryStage.setTitle("Feed Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public GridPane getGridPane()
   {
       Button btn1 = new Button("Calculate");
         Text TextMaize = new Text("Maize");
         textfieldForMaize = new TextField();
         
         
        Text TextSoya = new Text("Soya");
        textfieldForSoya = new TextField();
       
        
        Text gnutsText = new Text("Groundnuts");
        textfieldForgnuts = new TextField();
        
        
        Text saltText = new Text("Salt");
        textfieldForSalt = new TextField();
       
        
        GridPane gridPane = new GridPane();
        
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        gridPane.setAlignment(Pos.CENTER);
        
        gridPane.add(TextMaize, 0, 0);
        gridPane.add(textfieldForMaize, 1, 0);
        gridPane.add(TextSoya, 0, 1);
        gridPane.add(textfieldForSoya, 1, 1);
        gridPane.add(gnutsText, 0, 2);
        gridPane.add(textfieldForgnuts, 1, 2);
        gridPane.add(saltText, 0, 3);
        gridPane.add(textfieldForSalt, 1, 3);
        gridPane.add(btn1, 1, 4);
        btn1.setOnAction(action ->
        {
            CalculateTheFeed Calculate = new CalculateTheFeed();
            Calculate.feedCalculation();
         });
        return gridPane;
        
   }
    public VBox getVBox()
    {
        Button button = new Button("Calculate");
        
         VBox vbox = new VBox();
         //vbox.setPadding(new Insets(20,40,5,200));        
        ObservableList list = vbox.getChildren();
        list.addAll(getGridPane(),TextOutPut());
        
        return vbox;
    }
   public VBox TextOutPut()
   {
       VBox vbox = new VBox();
       textOutPut = new TextArea();
        textOutPut.setPrefColumnCount(15);
        textOutPut.setPrefRowCount(8 );
        
        ObservableList list = vbox.getChildren();
        list.addAll(textOutPut);
        
        vbox.setPadding(new Insets(20,40,5,53));
        
         return vbox;
   }
    public static void main(String[] args) {
        launch(args);
    }
    
}
abstract class CalculateFeed
{
    abstract void  feedCalculation();
   
 }
 
class CalculateTheFeed extends CalculateFeed
{
        FeedCalculator d2 = new FeedCalculator();
       String StringForMaize = d2.textfieldForMaize.getText();
       String StringForSoya   =d2.textfieldForSoya.getText();
      String  StringForGnuts  = d2.textfieldForgnuts.getText();
       String StringForSalt   = d2.textfieldForSalt.getText();
        
        double maizeMass = Double.parseDouble(StringForMaize);
       double soyaMass = Double.parseDouble(StringForSoya);
       double gnutsMass = Double.parseDouble(StringForGnuts);
       double saltMass = Double.parseDouble(StringForSalt);
        
    
    @Override
    public void feedCalculation()
    {
        
        
        
       Double[] doubleArray = new Double[4];
       doubleArray[0]=maizeMass;
       doubleArray[1]=soyaMass;
       doubleArray[2]=gnutsMass;
       doubleArray[3]=saltMass;
       for(int v=0; v<4; v++)
       {
           for(int i=0; i<3; i++ )
           {
               double q = doubleArray[i+1];
               if(doubleArray[i]>doubleArray[i+1])
               {
                   doubleArray[i+1]=doubleArray[i];
                   doubleArray[i]=q;
               }
           }
       }
      if (doubleArray[0]==saltMass)
      {
           double maize = saltMass*12;
          double soya = saltMass*4;
          double gnuts = saltMass*3;
          double salt = saltMass;
          
          if(maize>maizeMass)
           {
               
                   maize =maizeMass;
                  
                    soya = maize/3;
                    gnuts = maize/4;
                    salt = maize/12;
          
                    d2.textOutPut.setText("Maize  :" +maize+"\n" +"Soya" +soya+ "\n"+"Groudnuts" +gnuts+"\n"+"Salt"+salt);
           }
          else if(soya>soyaMass)
           {
               
                   soya =soyaMass;
                   
                     maize =soya *3;
                    soya = soya ;
                    gnuts = (soya *3)/4;
                    salt = soya /4;
          
                    d2.textOutPut.setText("Maize  :" +maize+"\n" +"Soya" +soya+ "\n"+"Groudnuts" +gnuts+"\n"+"Salt"+salt);
           }
          else if(gnuts>gnutsMass)
           {
               
                   gnuts =gnutsMass;
                   
                     maize = gnuts*4;
                    soya = (gnuts*4)/3;
                   
                    salt = gnuts/3;
          
                    d2.textOutPut.setText("Maize  :" +maize+"\n" +"Soya" +soya+ "\n"+"Groudnuts" +gnuts+"\n"+"Salt"+salt);
           }
           
           
           else
           {
               d2.textOutPut.setText("Maize   :" +maize+"\n" +"Soya" +soya+ "\n"+"Groudnuts  :" +gnuts+"\n"+"Salt   :"+salt);
   
           }
      }              
      
}
}