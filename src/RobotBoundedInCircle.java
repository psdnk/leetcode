public class RobotBoundedInCircle {

    public static void main(String[] args) {
        String instructions = "GG";
        System.out.println(isRobotBounded(instructions));
    }
    public static boolean isRobotBounded(String instructions) {
        int x=0,y=0;
        char current_direction = 'N';
        for (int i=0;i<instructions.length();i++){
            char current_instruction = instructions.charAt(i);
            if (current_instruction == 'G'){
                y += current_direction == 'N' ? 1:0;
                y += current_direction == 'S' ? -1:0;
                x += current_direction == 'E' ? 1:0;
                x += current_direction == 'W' ? -1:0;
            }else {
                if (current_direction == 'N') current_direction = current_instruction == 'L' ? 'W' : 'E';
                else if (current_direction == 'S') current_direction = current_instruction == 'L' ? 'E' : 'W';
                else if (current_direction == 'E') current_direction = current_instruction == 'L' ? 'N' : 'S';
                else  current_direction = current_instruction == 'L' ? 'S' : 'N';
            }
        }
        if ((x==0 && y==0) || current_direction!= 'N') return true;
        return false;

    }
}
