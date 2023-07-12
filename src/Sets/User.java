package Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private int userId;
    private String userName;
    private String userEmailID;

    public User(int userID,String userName,String userEmailID){
        this.userId=userID;
        this.userName=userName;
        this.userEmailID=userEmailID;
    }
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmailID() {
        return userEmailID;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmailID(String userEmailID) {
        this.userEmailID = userEmailID;
    }

    @Override
    public int hashCode() {
        return userEmailID.hashCode();
    }

    @Override
    public String toString() {
        return "User name: "+userName+"\nEmail id: "+userEmailID;
    }

    @Override
    public boolean equals(Object user) {
        User otherUser=(User) user;
        if(this.userEmailID.equals(otherUser.userEmailID)){
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args){

        List<User> users=new ArrayList<User>();
        users.add(new User(1001,"Sambhav","sambhavjain874@gmail.com"));
        users.add(new User(1002,"Kunal","kunal@gmail.com"));
        users.add(new User(1003,"Ayush","ayush@gmail.com"));
        users.add(new User(1004,"Shorya","shorya@gmail.com"));
        users.add(new User(1005,"Shaurya","shorya@gmail.com"));

        Set<User> usersList=new HashSet<User>();
        usersList.addAll(users);
        for(User usr:usersList){
            System.out.println(usr);
            System.out.println();
        }
    }
}
