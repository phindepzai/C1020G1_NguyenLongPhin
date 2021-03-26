package binzet.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String getResult(int number1, int number2 ,String operate) {
        String result;
        switch (operate){
            case "cong":
                result = number1 + number2 + "";
                break;
            case "tru":
                result = number1 - number2 + "";
                break;
            case "nhan":
                result = number1 * number2 + "";
                break;
            default:
                if (number2 != 0){
                    result = number1 * 1.0 / number2 + "";
                } else {
                    result = "can't divided by 0";
                }
        }
        return result;
    }
}
