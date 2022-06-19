package classes;
import javax.swing.JFrame;
import java.util.Scanner;
import classes.*;

public class BouncingBall {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your maximum ball numbers:");
		int num = scanner.nextInt();
		JFrame application = new JFrame("Bouncing Ball");
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BouncingBallPanel ballsJPanel = new BouncingBallPanel(num);
		application.add(ballsJPanel);

		application.setSize(400, 400);
		application.setLocationRelativeTo(null);
		application.setVisible(true);
	}
}
