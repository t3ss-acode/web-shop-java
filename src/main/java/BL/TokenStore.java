package BL;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenStore {
    private Map<String, TokenData> tokenMap = new HashMap<>();

    private static TokenStore instance = new TokenStore();
    public static TokenStore getInstance(){return instance;}

    private TokenStore(){}

    public String putToken(String username){
        String token = UUID.randomUUID().toString();
        tokenMap.put(token, new TokenData(username));
        return token;
    }

    public String getUsername(String token){
        if (tokenMap.containsKey(token)){
            if (tokenMap.get(token).expirationTime > System.currentTimeMillis())
                return tokenMap.get(token).username;
            else
                tokenMap.remove(token);
        }
        return null;
    }

    public boolean checkToken(String token){
        if (tokenMap.containsKey(token))
            if (tokenMap.get(token).expirationTime > System.currentTimeMillis())
                return true;
            else
                tokenMap.remove(token);
        return false;
    }

    private static class TokenData{
        String username;
        long expirationTime;

        private TokenData(String username){
            this.username = username;
            //15 min
            expirationTime = System.currentTimeMillis() + 15 * 60 * 1000;
        }
    }
}
