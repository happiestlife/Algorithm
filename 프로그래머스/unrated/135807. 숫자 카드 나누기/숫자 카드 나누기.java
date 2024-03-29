import java.util.*;

class Solution {
    
//     public void initComp(Set<Integer> comp, int a){
//         for(int i = 2; i <= a; i++){
//             if(a % i == 0){
//                 comp.add(i);
//             }
//         }
//     }
    
//     public void calculateComp(Set<Integer> comp, int a){
//         int[] compArr = comp.stream().mapToInt(i -> i).toArray();
//         for(int divisor : compArr){
//             if(a % divisor != 0){
//                 comp.remove(divisor);
//             }
//         }
//     }
    
//     public boolean isSuccess(int[] opponent, int divisor){
//         for(int i = 0; i < opponent.length; i++){
//             if(opponent[i] % divisor == 0){
//                 return false;
//             }
//         }
        
//         return true;
//     }
    
//     public int solution(int[] arrayA, int[] arrayB) {
//         Set<Integer> aCommonComp = new HashSet<>();
//         Set<Integer> bCommonComp = new HashSet<>();
    
//         initComp(aCommonComp, arrayA[0]);
//         initComp(bCommonComp, arrayB[0]);
        
//         for(int i = 1; i < arrayA.length; i++){
//             calculateComp(aCommonComp, arrayA[i]);
//             calculateComp(bCommonComp, arrayB[i]);
//         }
        
//         int[] arrA = aCommonComp.stream().mapToInt(i -> i).toArray();
//         int[] arrB = bCommonComp.stream().mapToInt(i -> i).toArray();
        
//         Arrays.sort(arrA);
//         Arrays.sort(arrB);
        
//         int idxA = arrA.length - 1, idxB = arrB.length - 1;
//         while(idxA >= 0 && idxB >= 0){
//             if(arrA[idxA] > arrB[idxB]){
//                 if(!bCommonComp.contains(arrA[idxA]) && isSuccess(arrayB, arrA[idxA])){
//                     return arrA[idxA];
//                 }
//                 else{
//                     idxA--;
//                 }
//             }
//             else{
//                 if(!aCommonComp.contains(arrB[idxB]) && isSuccess(arrayA, arrB[idxB])){
//                     return arrB[idxB];
//                 }
//                 else{
//                     idxB--;
//                 }
//             }
//         }
        
//         while(idxA >= 0){
//             if(!bCommonComp.contains(arrA[idxA]) && isSuccess(arrayB, arrA[idxA])){
//                 return arrA[idxA];
//             }
//             idxA--;
//         }

//         while(idxB >= 0){
//             if(!aCommonComp.contains(arrB[idxB]) && isSuccess(arrayA, arrB[idxB])){
//                 return arrB[idxB];
//             }
//             idxB--;
//         }
        
//         return 0;
//     }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int aMin = getMin(arrayA);
        int aGcd = getArraysGcd(arrayA, aMin);
        System.out.println(aMin + ", " + aGcd);

        int bMin = getMin(arrayB);
        int bGcd = getArraysGcd(arrayB, bMin);
        System.out.println(bMin + ", " + bGcd);

        answer = getAnswer(aGcd, arrayB, answer);
        answer = getAnswer(bGcd, arrayA, answer);

        return answer;
    }

    private static int getAnswer(int gcd, int[] array, int answer) {
        for (int num : array) {
            if (num % gcd == 0) {
                return Math.max(answer, 0);
            }
        }
        return Math.max(answer, gcd);
    }

    private static int getMin(int[] array) {
        return Arrays.stream(array)
                .reduce(Math::min)
                .getAsInt();
    }

    private static int getArraysGcd(int[] array, int min) {
        int gcd = 1;
        for (int i = 2; i <= min; i++) {
            if (isGcd(array, i)) {
                gcd = i;
            }
        }
        return gcd;
    }
    
    private static boolean isGcd(int[] array, int i) {
        for (int num : array) {
            if (num % i != 0) {
                return false;
            }
        }
        return true;
    }
}