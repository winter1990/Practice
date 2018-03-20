package practice.interview;

import java.util.*;

public class UserImpl implements Apis {
    Map<String, User> userCollection = new HashMap<>();
    Set<String> emailSet = new HashSet<>();
    /**
     * Cannot create new user if a user with same email already exists O(1)
     * use map, key: username, value:
     * set<string>, put email in the data structure
     */
    @Override
    public void createUser(User user) {
        if (emailSet.contains(user.getEmail())) {
            System.out.println("The email already exists. User not created.");
            return;
        } else {
            if (user.getUsername().equals("") || user.getEmail().equals("")) {
                System.out.println("User name and email can not be empty.");
                return;
            }
            userCollection.put(user.getUsername(), user);
            emailSet.add(user.getEmail());
            System.out.println("User" + user.getUsername() + " created");
        }
    }

    /**
     * O(1) run time
     * map, username and User Object
     */
    @Override
    public User findUser(String username) {
        if (username.equals("")) {
            System.out.println("Cannot find the user with empty user name.");
            return null;
        }
        if (userCollection.containsKey(username)) {
            return userCollection.get(username);
        } else {
            System.out.println("User not found.");
            return null;
        }
    }

    /**
     * search for users by search criteria (can be by the username, email, firstname or lastname)
     * Can run in O(n)
     * reuser the map username and User Object
     */
    @Override
    public List<User> searchUsers(String searchCriteria) {
        List<User> users = new ArrayList<>();
        for (String u : userCollection.keySet()) {
            if (u.equals(searchCriteria)
                    || userCollection.get(u).getFirstName().equals(searchCriteria)
                    || userCollection.get(u).getLastName().equals(searchCriteria)
                    || userCollection.get(u).getEmail().equals(searchCriteria)) {
                users.add(userCollection.get(u));
            }
        }
        printOutSearchResult(users, searchCriteria);
        return users;
    }

    private void printOutSearchResult(List<User> users, String searchCriteria) {
        if (users.size() == 0) {
            System.out.println("No user found based on criteria.");
        } else {
            System.out.println("Following users are found based on the criteria - " + searchCriteria);
            for (User u : users) {
                System.out.print(u.getUsername() + " ");
            }
            System.out.println();
        }
    }

    /**
     * delete entry in the map
     * delete data in the set
     */
    @Override
    public void deleteUser(String username) {
        if (userCollection.containsKey(username)) {
            String email = userCollection.get(username).getEmail();
            emailSet.remove(email);
            userCollection.remove(username);
            System.out.println("user - " + username + " deleted.");
        }
    }
}
