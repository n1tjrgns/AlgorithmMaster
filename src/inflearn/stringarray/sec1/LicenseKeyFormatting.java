package inflearn.stringarray.sec1;

//https://leetcode.com/problems/license-key-formatting/
public class LicenseKeyFormatting {
    //1. 첫번째 그룹을 제외한 나머지는 k만큼의 글자수 그룹으로 이루어진다.
    //1-1. 첫번째 그룹은 k보다 작아도 되지만 적어도 1개는 포함해야 한다.
    //2. 각 그룹 사이는 -로 이루어진다.
    //3. 대문자만 사용해야한다.
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-", "").toUpperCase();
        StringBuffer sb = new StringBuffer(s);

        int i = sb.length() - k;
        System.out.println("i = " + i);

        //처음 그룹은 k보다 작기만하면 되기때문에 뒤에서부터 넣는다.
        while (i > 0){
            sb.insert(i, '-');
            i = i-k;
            System.out.println("i = " + i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LicenseKeyFormatting l = new LicenseKeyFormatting();
        System.out.println(l.licenseKeyFormatting("5F3Z-2e-9-w",4));
    }
}
