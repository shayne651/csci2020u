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
import java.io.*;

public class lab07 extends Application 
{
    private int[] disasters = {0,0,0,0};
    private static Color[] pieColours = {Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Group root = new Group();
        canvas = new Canvas(800,600);
        primaryStage.setTitle("Lab 07");
        
        draw(root);
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void readData()
    {
        String line=null;
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("weatherwarnings-2015.csv"));
            while ((line = br.readLine())!=null)
            {
                if (line.toUpperCase().contains("FLASH FLOOD"))
                {
                    disasters[0]+=1;
                }
                else if (line.toUpperCase().contains("SEVERE THUNDERSTORM"))
                {
                    disasters[1]+=1;
                }
                else if (line.toUpperCase().contains("SPECIAL MARINE"))
                {
                    disasters[2]+=1;
                }
                else if (line.toUpperCase().contains("TORNADO"))
                {
                    disasters[3]+=1;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void draw(Group group) 
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        readData();
        int total =0;
        for (int i=0;i<=3;i++)
        {
            total+=disasters[i];
            System.out.println(disasters[i]);
        }
        System.out.println(total);
        float start=0;
        float end;
            for (int i=0;i<=3;i++)
            {
                end=((float)disasters[i]/total)*360;
                gc.setFill(pieColours[i]);
                gc.fillArc(450,200,200,200,start,end,ArcType.ROUND);
                start+=end;


            }

        Font font = new Font("Arial", 24);
        gc.setFont(font);
        gc.setFill(Color.BLACK);
        gc.fillText("FLash FLood", 100, 100);

        gc.setFill(Color.AQUA);
        gc.fillRect(75, 90, 10, 10);

        gc.setFill(Color.BLACK);
        gc.fillText("Severe Thunder Storm", 100, 200);

        gc.setFill(Color.GOLD);
        gc.fillRect(75, 190, 10, 10);

        gc.setFill(Color.BLACK);
        gc.fillText("Special Marine", 100, 300);

        gc.setFill(Color.DARKORANGE);
        gc.fillRect(75, 290, 10, 10);

        gc.setFill(Color.BLACK);
        gc.fillText("Tornado", 100, 400);

        gc.setFill(Color.DARKSALMON);
        gc.fillRect(75, 390, 10, 10);
    }

    public static void main(String[] args) {
        launch(args);
    }
}