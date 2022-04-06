import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        "IP={IP.Address} message={A&sample&message} user={username}"
//         IP=192.23.30.40 message='Hello&derps.' user=destroyer
        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> userIPInfo = new TreeMap<>();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String[] ipArr = tokens[0].split("=");
            String ip = ipArr[1];

            String[] userArr = tokens[2].split("=");
            String userName = userArr[1];

            userIPInfo.putIfAbsent(userName, new LinkedHashMap<>());
            Map<String, Integer> ipCounter = userIPInfo.get(userName);

            if (ipCounter.containsKey(ip)) {
                ipCounter.put(ip, ipCounter.get(ip) + 1);
            } else {
                ipCounter.put(ip, 1);
            }

            input = scanner.nextLine();
        }
//        "username:
//        {IP} => {count}, {IP} => {count}."

        userIPInfo.forEach((key, value) -> {
            System.out.println(key + ":");

            int count = 0;
            for (Map.Entry<String, Integer> secondMap : value.entrySet()) {
                String format = count++ != value.size() - 1 ? "%s => %d, " : "%s => %d.%n";
                System.out.printf(format, secondMap.getKey(), secondMap.getValue());
            }
        });
    }
}
