package video_rental;

public class Video {
String videoName;
boolean checkout;
int rating;
Video(String name){
	videoName=name;
}
public String getName() {
	return videoName;
}
public void doCheckout() {
	checkout=true;
}
public void doReturn() {
	
}
public void receiveRating(int rat) {
	rating=rat;
}
public int getRating() {
	return rating;
}
boolean getCheckout() {
	return checkout;
}
}
