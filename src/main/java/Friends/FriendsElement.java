package Friends;
import utils.User;

public class FriendsElement {
    private String profile = "//a[@href='/profile/']";
    private String messageXpath = "//a[@href='/messages/']";
    private String phoneXpath = "//a[@href='/dk?cmd=VideoChatCall&st.call.opponentId=&st.call.dir=OUTGOING&st.call.ft=CALL_VIDEO&st.cmd=userFriend&msgLIR=on&st._aid=SquareCardFriends_CallClickV2']";
    private String profileButton;
    private String messageButton;
    private String phoneButton;

    public String getMessageButton() {
        return messageButton;
    }

    public String getPhoneButton() {
        return phoneButton;
    }

    public String getProfileButton() {

        return profileButton;
    }

    public FriendsElement createFriendElement(User user, int index){
        profileButton = profile.substring(0,20) + user.getFriendsIds().get(index) + profile.substring(20);
        messageButton = messageXpath.substring(0,21) + user.getFriendsIds().get(index) + messageXpath.substring(21);
        phoneButton = phoneXpath.substring(0,52) + user.getFriendsIds().get(index) + phoneXpath.substring(52);
        return this;
    }

    }


