package dhl.CreateTeamUtils;

import java.util.List;

public class ManagerUtils implements IManagerUtils{
    @Override
    public void displayManager(List<String> managerList) {
        for (String s : managerList) {
            System.out.println(s);
        }
    }

    @Override
    public void removeManager(List<String> managerList, String managerName) {
        for(int i = 0; i < managerList.size(); i++){
            if (managerList.get(i).equals(managerName)) {
                managerList.remove(i);
            }
        }
    }
}
