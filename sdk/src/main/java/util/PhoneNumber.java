package util;
import java.util.*;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :王海瑞 2017/2/23
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博科技有限公司 </p>
 */
public final class PhoneNumber implements Comparable<PhoneNumber> {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "lineNumber");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ":" + arg);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNumber == lineNumber && pn.areaCode == areaCode && pn.prefix == prefix;
    }

    @Override
    public int hashCode() {
        int result = 17;
        //31*i=(i<<5)-i
        result = 31 * result + areaCode;
        result = 31 * result + prefix;
        result = 31 * result + lineNumber;
        return result;
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
        m.put(new PhoneNumber(707, 867, 5309), "jenny");
        String name = m.get(new PhoneNumber(707, 867, 5309));
        System.out.println(name);
        int s= new PhoneNumber(707, 867, 5309).compareTo(new PhoneNumber(707, 1, 1));
        System.out.println(s);
    }
    public int compareTo(PhoneNumber pn) {
        int areaCodeDiff = areaCode - pn.areaCode;
        if (areaCodeDiff != 0)
            return areaCodeDiff;
        int prefixDiff = prefix - pn.prefix;
        if (prefix != 0)
            return prefixDiff;
        return lineNumber - pn.lineNumber;
		//return areaCode-pn.areaCode!=0?areaCode-pn.areaCode:prefix - pn.prefix!=0?prefix - pn.prefix:lineNumber - pn.lineNumber
    }
}
