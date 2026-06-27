public class FinancialForecast {

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // 1. The Base Case
        if (years == 0) {
            return presentValue;
        }
        
        // 2. The Recursive Step
        double previousYearValue = calculateFutureValue(presentValue, growthRate, years - 1);
        return previousYearValue * (1 + growthRate);
    }

    public static void main(String[] args) {
        double initialInvestment = 10000.00; // $10,000
        double annualGrowthRate = 0.07;      // 7% growth
        int targetYears = 5;                 // Forecast for 5 years

        System.out.println("--- Financial Forecasting ---");
        System.out.println("Initial Investment: $" + initialInvestment);
        System.out.println("Expected Annual Growth: 7%");
        
        double projectedValue = calculateFutureValue(initialInvestment, annualGrowthRate, targetYears);
        
        System.out.printf("Projected value after %d years: $%.2f%n", targetYears, projectedValue);
    }
}