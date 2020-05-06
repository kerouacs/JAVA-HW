/** 
 * This program is about computing ther angle between the hour hand and the minute hand 
 * and test for the values 9:00,3:00,18:00,1:00,2:30,4:41,0:00:20 and 13:05:27.272727272727
 * the most important is that The hour hand goes 0.5 degrees per minute, 1/120 degrees per second.
 * The minute hand travels 0.1 degree per second.
 * and 1 minute 6 degrees ,1hour 30 degrees.
 * @author  RUOPENG JIANG
 * @since 2019-10-06
 * @version 2019-07-16
 */
class EX3{
	public static int timeToAngle(int hours,int minutes){
		int minutesangle=6*minutes;
		double hoursangle=(hours%12)*30+minutes*0.5;//why use (mintues/60*30) get different results with minutes*0.5?
		return (int)Math.round((hoursangle+360-minutesangle)%360);
	}
	public static void main(String[] args){
        int t1=timeToAngle(9,0);
        System.out.println("t1="+t1);
        int t2=timeToAngle(3,0);
        System.out.println("t2="+t2);
        int t3=timeToAngle(18,0);
        System.out.println("t3="+t3);
        int t4=timeToAngle(1,0);
        System.out.println("t4="+t4);
        int t5=timeToAngle(2,30);
        System.out.println("t5="+t5);
        int t6=timeToAngle(4,41);
        System.out.println("t6="+t6);
		double t7=timeToAngle1(0,0,20);
        System.out.println("t7="+t7);
		double t8=timeToAngle1(13,5,27.272727272727);
        System.out.println("t8="+t8);
	}
	public static int timeToAngle1(int hours,int minutes,double secounds){
		double minutesangle=6*minutes+secounds*0.1;
		double hoursangle=(hours%12)*30+minutes*0.5+secounds*1/120;
		return (int)Math.round((hoursangle+360-minutesangle)%360);
	}
}
