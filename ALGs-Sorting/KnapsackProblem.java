public class KnapsackProblem {

    public static int knapsack(int[] itemsWeights, int[] itemsValues, int bagTotalCapacity) {
		int totalNumberOfItems = itemsWeights.length;
		// Best Bag Value Per ItemsAmount And Given Capacity
		int[][] bestBagValue = new int[totalNumberOfItems + 1][bagTotalCapacity + 1]; // translates to array[rows][columns]
		// Build the table from the bottom up
		for (int forItemsAmount = 1, itemIndex = 0; forItemsAmount <= totalNumberOfItems; forItemsAmount++, itemIndex++) {
			
			int currentItemWeight = itemsWeights[itemIndex];
			int currentItemValue = itemsValues[itemIndex];

			for (int forAllowedWeight = 1; forAllowedWeight <= bagTotalCapacity; forAllowedWeight++) {

				if (currentItemWeight <= forAllowedWeight) {

					bestBagValue[forItemsAmount][forAllowedWeight] =
							Math.max(
									bestBagValue[forItemsAmount-1][forAllowedWeight],
									currentItemValue + bestBagValue[forItemsAmount-1][forAllowedWeight - currentItemWeight]
							);
				} else {
					bestBagValue[forItemsAmount][forAllowedWeight] = bestBagValue[forItemsAmount - 1][forAllowedWeight];
				}
			}
		}
		return bestBagValue[totalNumberOfItems][bagTotalCapacity];
	}

    public static void main(String[] args) {
        int[] itemsValues = {60, 100, 120, 150};
        int[] itemsWeights = {10, 20, 30, 5};
        int bagMaxCapacity = 50;

        int bagMaxValue = knapsack(itemsWeights, itemsValues, bagMaxCapacity);

        System.out.println("Maximum value in the Bag for a given capacity: " + bagMaxValue);
    }
    
}
