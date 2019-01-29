package practice.interview.other;


public class Solution {
    public static void main(String[] args) {
        User u1 = new User("user1", "u1@abc.com", "123", "a1","b1");
        User u2 = new User("user2", "u2@abc.com", "234", "a2","b2");
        User duplicateUser = new User("user1", "u1@abc.com", "456", "a1","b1");
        User emptyUser = new User("", "u3@abc.com", "345", "a3","b3");
        User u3 = new User("user3", "u3@abc.com", "456", "a1","b1");
        User u4 = new User("user4", "u4@abc.com", "567", "a4","b4");

        UserImpl app = new UserImpl();

        // user creation, positive cases
        app.createUser(u1);
//        Assert.assertEquals(true, app.userCollection.containsKey("user1"));
//        Assert.assertEquals(true, app.emailSet.contains("u1@abc.com"));
        app.createUser(u2);
//        Assert.assertEquals(2, app.userCollection.size());

        // create user with duplicate email
        app.createUser(duplicateUser);
//        Assert.assertEquals(2, app.userCollection.size());

        // user creation, negative cases
        app.createUser(emptyUser);
//        Assert.assertEquals(2, app.userCollection.size());
//        Assert.assertEquals(true, app.userCollection.containsKey("user1"));
//        Assert.assertEquals(true, app.emailSet.contains("u1@abc.com"));
//        Assert.assertEquals(true, app.userCollection.containsKey("user2"));
//        Assert.assertEquals(true, app.emailSet.contains("u2@abc.com"));

        // find user
//        Assert.assertEquals(null, app.findUser("sdafdsafasdf"));
//        Assert.assertEquals(null, app.findUser(""));
//        Assert.assertEquals(u1, app.findUser("user1"));
//        Assert.assertEquals(u2, app.findUser("user2"));

        // search by different criteria
        app.createUser(u3); // the user 3 has the same last and first name with user 1 but different username and email
//        Assert.assertEquals(1, app.searchUsers("user2").size());
//        Assert.assertEquals(2, app.searchUsers("a1").size());
//        Assert.assertEquals(2, app.searchUsers("b1").size());
//        Assert.assertEquals(1, app.searchUsers("u3@abc.com").size());

        // delete user
        app.createUser(u4);
//        Assert.assertEquals(true, app.userCollection.containsKey("user4"));
//        Assert.assertEquals(true, app.emailSet.contains("u4@abc.com"));
        app.deleteUser("user4");
//        Assert.assertEquals(false, app.userCollection.containsKey("user4"));
//        Assert.assertEquals(false, app.emailSet.contains("u4@abc.com"));
    }
}
