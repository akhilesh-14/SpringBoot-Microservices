package com.example.media.media.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {
private static List<User> users = new ArrayList<>();
private static int userCount = 0;
static {
    users.add(new User(++userCount,"Akhil", LocalDate.now().minusYears(30)));
    users.add(new User(++userCount,"Sailesh", LocalDate.now().minusYears(25)));
    users.add(new User(++userCount,"Laddu", LocalDate.now().minusYears(40)));
}

public List<User> FindAll(){
    return users;
}

public User addUser(User user){
    user.setId(++userCount);
    users.add(user);
    return user;
}

public User findOne(int id){
    Predicate<? super User> predicate= user -> user.getId().equals(id);
   return users.stream().filter(predicate).findFirst().orElse(null);
}

}
