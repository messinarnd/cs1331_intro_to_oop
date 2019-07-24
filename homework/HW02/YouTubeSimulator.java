// I worked on this alone using course materials and the internet
import java.text.NumberFormat;
import java.util.Scanner;

public class YouTubeSimulator {
	public static void main(String[] args) {
		String response = new String("N");
		do{
			System.out.println("\nWhat is your name? ");
			Scanner scan = new Scanner(System.in);
			String name = scan.nextLine();
			System.out.println("\nInitial Subscribers: ");
			int subs = scan.nextInt();
			int mySubs = subs;
			System.out.println("\nHow many weeks would you like to simulate? ");
			int weeks = scan.nextInt();
			System.out.printf("\nSimulating %d weeks:\n",weeks);
			int initWeeks = weeks;
			int videos;
			int totalVideos = 0;
			int pastVids = 0;
			int collabVids = 0;
			int collabSubs;
			int weeklySubs;
			double friendSubs;
			int newSubs;
			int thisWeek = 0;
			int views = 0;
			int expectedViews;
			int weeklyViews;
			int pastViews = 0;
			double adRev;
			double weeklyAdRev;
			NumberFormat dollars = NumberFormat.getCurrencyInstance();
			do {
				//Subscribers
				weeks = weeks-1;
				thisWeek = thisWeek+1;
				System.out.printf("\nHow many videos will be made in week %d? (1-5)\n",thisWeek);
				videos = scan.nextInt();
				totalVideos = totalVideos + videos;
				for (;videos<1 && videos>5;){
					System.out.println("\nPlease enter a number between 1 and 5:\n");
					videos = scan.nextInt();
					continue;
				}
				weeklySubs = (int)(mySubs * .02);
				mySubs = mySubs + weeklySubs;
				if (weeks==initWeeks-4) {
					friendSubs = mySubs * 1.2;
					collabSubs = (int)(friendSubs * 0.3);
					System.out.printf("\nCongrats on your collab! You gained %d subscribers\n\n",collabSubs);
					initWeeks = initWeeks-4;
					newSubs = weeklySubs + collabSubs;
					mySubs = collabSubs + mySubs;
					collabVids = collabVids+1;
				}
				else {
					newSubs = weeklySubs;
				}
				System.out.printf("\n%s\'s Weekly Summary for Week %d:\n",name,thisWeek);
				System.out.printf("%10d : Videos\n",videos);
				System.out.printf("%10d : New Subscribers\n",newSubs);

				//Views
				expectedViews = (int)(mySubs*0.6);
				weeklyViews = (int)(expectedViews*videos);
				pastViews = (int)(mySubs*0.05*pastVids);
				pastVids = pastVids + videos;
				views = weeklyViews+pastViews+views;
				System.out.printf("%10d : Views\n",weeklyViews);

				//Ad Revenue
				adRev = views*0.05;
				weeklyAdRev = weeklyViews*0.05;
				String weeklyRev = dollars.format(weeklyAdRev);
				System.out.println(weeklyRev + " : Ad Revenue");


				if (weeks != 0) {
					scan.nextLine();
					System.out.print("\nPress Enter to go to next week");
					scan.nextLine();
				}
				else {
					scan.nextLine();
					System.out.print("\nPress Enter to go to Total Summary");
					scan.nextLine();
				}

			} while (weeks>0);

			System.out.printf("\n%s\'s Total Summary:\n",name);
			System.out.printf("%10d : Total Videos\n",totalVideos);
			System.out.printf("%10d : Collaboration Videos\n",collabVids);
			System.out.printf("%10d : Total Views\n",views);
			System.out.printf("%10d : Subscribers\n",mySubs);
			String revenue = dollars.format(adRev);
			System.out.println(revenue + " : Ad Revenue");

			System.out.println("Would you like to keep simulating? [Y/N]");
			response = scan.nextLine();

		} while (response.equals("Y") || response.equals("y"));
	}
}