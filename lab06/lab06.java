import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

public class lab06 extends Application {

 	private static double[] avgHousingPricesByYear = {247381.0, 264171.4, 287715.3, 294736.1, 308431.4, 322635.9, 340253.0, 363153.7};
    private static double[] avgCommercialPricesByYear = {1121585.3, 1219479.5, 1246354.2, 1295364.8, 1335932.6, 1472362.0, 1583521.9, 1613246.3};
    private static String[] ageGroups = {"18 - 25" , "26 - 35" , "36 - 45" , "46 - 55" , "56 - 65" , "65+"};
    private static int[] purchasesByAgeGroup = {648, 1021, 2453, 3173, 1868, 2247};
    private static Color[] pieColours = {Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Group root = new Group();
        canvas = new Canvas(800,600);
        primaryStage.setTitle("Lab 06");
        
        draw(root);
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   

    private void draw(Group group) 
    {
    	GraphicsContext gc = canvas.getGraphicsContext2D();
        
        for (int i=0;i<=7;i++)
        {
        	gc.setFill(Color.RED);
            gc.fillRect(40 + (i*30+(15*i)),500-(250*(avgHousingPricesByYear[i]/avgCommercialPricesByYear[7])),15,250*(avgHousingPricesByYear[i]/avgCommercialPricesByYear[7])); 
            gc.setFill(Color.BLUE);
            gc.fillRect(70+(i*30+(15*i-15)),500-(250*(avgCommercialPricesByYear[i]/avgCommercialPricesByYear[7])),15,250*(avgCommercialPricesByYear[i]/avgCommercialPricesByYear[7]));
        }
        int total =0;
        for (int i=0;i<=5;i++)
        {
        	total+=purchasesByAgeGroup[i];
        }
        System.out.println(total);
        float start=0;
        float end;
        	for (int i=0;i<=5;i++)
        	{
        		end=((float)purchasesByAgeGroup[i]/total)*360;
	        	gc.setFill(pieColours[i]);
	        	gc.fillArc(400,300,200,200,start,end,ArcType.ROUND);
	        	start+=end;
        	}
        
    }





    public static void main(String[] args) {
        launch(args);
    }
}