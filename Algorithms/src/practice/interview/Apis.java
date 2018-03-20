package practice.interview;


import java.util.List;

public interface Apis {

    /*
     * Creates a new user and store it.
     * All User attributes are required.
     * Cannot create new user if a user with same email already exists.
     * Needs to run in O(1)
     */
    void createUser(User user);

    /*
     * Find user by its username (shoule run in O(1))
     */
    User findUser(String username);

    // search for users by search criteria (can be by the username, email, firstname or lastname)
    // Can run in O(n)
    List<User> searchUsers(String searchCriteria);

    // deletes user from the store
    // Needs to run in O(1)
    void deleteUser(String username);

}