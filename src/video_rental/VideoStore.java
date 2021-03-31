package video_rental;
import java.util.ArrayList;
public class VideoStore {
    ArrayList<Video> v=new ArrayList<Video>();
    Video ob;
public int addVideo(String name) {
	if(name.equals("")) {
		return 0;
	}
	else 
	ob=new Video(name);
	v.add(ob);
	return 1;
}
public int doCheckout(String name) {
	int i;
	for(i=0;i<v.size();i++) {
		Video a=v.get(i);
		if(a.videoName.equals(name)) {
			a.checkout=true;
			return 1;
		}
	}
	return 0;
}
public int doReturn(String Name) {
	int i;
	for(i=0;i<v.size();i++) {
		Video a=v.get(i);
		if(a.videoName.equals(Name)) {
			a.checkout=false;
			return 1;
		}
	}
	return 0;
}
public int receiveRating(String name,int rate) {
	int i;
	for(i=0;i<v.size();i++) {
		Video a=v.get(i);
		if(a.videoName.equals(name)) {
			a.rating=rate;
			return 1;
		}
	}
	return 0;
}
public String listInventory() {
	String str;
	str="Videoname |Checkout Status |Rating";
	str=str+"\n";
	int i;
	for(i=0;i<v.size();i++) {
		Video a=v.get(i);
		str=str+a.videoName+"     "+a.checkout+"   "+a.rating;
		str=str+"\n";
	}
	return str;
}
}
