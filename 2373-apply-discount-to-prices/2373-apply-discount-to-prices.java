class Solution {
    public String discountPrices(String sentence, int discount) {

        String[] words = sentence.split(" ");

        double dis = (100 - discount) / 100.0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith("$") && words[i].substring(1).matches("\\d+")) {
                double price = Double.parseDouble(words[i].substring(1)) * dis;
                words[i] = String.format("$%.2f", price);
            }
        }

        return String.join(" ", words);
    }
}