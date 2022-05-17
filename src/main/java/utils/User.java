package utils;

import Friends.FriendsElement;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String login;
    private String password;
    private String name;
    private String surname;
    private List<String> messageIds = new ArrayList<String>();
    private List<String> friendsIds = new ArrayList<String>();

    public String getLogin(){
        return login;
    };
    public String getPassword(){
        return password;
    };
    public String getName(){
        return name;
    };
    public String getSurname(){
        return surname;
    };
    public List<String> getMessageIds(){
        return messageIds;
    };
    public List<String> getFriendsIds(){
        return friendsIds;
    };

    public String getFullNameFromUser(){
       return name + " " + surname;
    };

    private User(UserBuilder builder) {
        this.login = builder.login;
        this.password = builder.password;
        this.name = builder.name;
        this.surname = builder.surname;
        this.messageIds = builder.messageIds;
        this.friendsIds = builder.friendsIds;
    }

    public static class UserBuilder {
        private String login;
        private String password;
        private String name;
        private String surname;
        private List<String> messageIds = new ArrayList<String>();
        private List<String> friendsIds = new ArrayList<String>();

        public UserBuilder(String login, String password) {
            this.login = login;
            this.password = password;
        }
        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }
        public UserBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }
        public UserBuilder withMessageIds(List<String> messageIds) {
            this.messageIds = messageIds;
            return this;
        }
        public UserBuilder withFriendsIds(List<String> friendsIdsIds) {
            this.friendsIds = friendsIdsIds;
            return this;
        }
        public User build() {
            User user =  new User(this);
            return user;
        }
    }
}
