<%@ tag body-content="empty" %>
<%@ attribute name="numbers" required="true" %>

<%
    String input = numbers;

    String[] arr = input.split(",");
    int[] nums = new int[arr.length];

    for(int i=0;i<arr.length;i++){
        nums[i] = Integer.parseInt(arr[i].trim());
    }

    // Sorting (Ascending)
    for(int i=0;i<nums.length;i++){
        for(int j=i+1;j<nums.length;j++){
            if(nums[i] > nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
%>

<h3>Sorted Numbers:</h3>

<%
    for(int n : nums){
        out.print(n + " ");
    }
%>