class Solution {
    public static int[] constructRectangle(int area) {
        
    	int wid = (int) Math.sqrt(area);
    	
    	while(area % wid != 0) {
    		wid--;
    	}
    	
    	int len = area / wid;
    	
    	return new int[] {len, wid};
    	
    }
}