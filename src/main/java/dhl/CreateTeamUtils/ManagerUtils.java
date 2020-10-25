package dhl.CreateTeamUtils;

import java.util.ArrayList;

public class ManagerUtils implements IManagerUtils{
    @Override
    public void displayManager(ArrayList<String> managerList) {
        for(int i = 0; i < managerList.size(); i++){
            System.out.println(managerList.get(i));
        }
    }

    @Override
    public void removeManager(ArrayList<String> managerList, String managerName) {
        for(int i = 0; i < managerList.size(); i++){
            if (managerList.get(i).equals(managerName)) {
                managerList.remove(i);
            }
        }
    }
}
