package src.com.algo;

import java.util.*;

public class AccountsMerge {
    public Integer ID = 1;

    class Account{
        Integer id=1;
        String name;
        TreeSet<String> emails = new TreeSet<String>();

        public Account(){
            id = ID++;
        }

        @Override
        public boolean equals(Object obj){
            if(obj == this) return true;
            if(obj == null) return false;
            if( !(obj instanceof Account)) return false;
            Account ac = (Account) obj;
            return (ac.id.equals(this.id));
        }
        @Override
        public int hashCode(){
            return id;
        }

    }

    HashMap<String, ArrayList<Account>> map = new HashMap<String, ArrayList<Account>>();
    HashMap<Account, String> mapAcc = new HashMap<Account, String>();


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        for(List<String> acc : accounts){
            Account account = new Account();

            String name = null;
            for(String s : acc){
                if(name==null){
                    name = s;
                    account.name = s;
                    continue;
                }
                account.emails.add(s);
            }
            mapAcc.put(account, name);

            for(String email : account.emails){
                ArrayList<Account> ls = null;
                if(map.containsKey(email)){
                    ls = map.get(email);
                    ls.add(account);
                }else{
                    ls = new ArrayList<Account>();
                    ls.add(account);
                }
                map.put(email, ls);
            }
        }

        List<List<String>> retList = new ArrayList<List<String>>();
        ArrayList<String> mergedList = null;

        for(Map.Entry<String, ArrayList<Account>> entry : map.entrySet()){
            Account ac = entry.getValue().get(0);
            mergedList = new ArrayList<String>();

            if(entry.getValue().size()>1){
                for(int i=0; i<entry.getValue().size();i++){
                    ac.emails.addAll(entry.getValue().get(i).emails);
                    mapAcc.remove(entry.getValue().get(i));
                    
                }
                mapAcc.remove(ac);
                mergedList.add(ac.name);
                mergedList.addAll(ac.emails);
                retList.add(mergedList);
            }
            
        }
        for(Account acc : mapAcc.keySet()){
            mergedList = new ArrayList<String>();
            mergedList.add(acc.name);
            mergedList.addAll(acc.emails);
            retList.add(mergedList);
        }

        return retList;
    }
    
    public static void main(String[] args) {
        
    }
    
}
