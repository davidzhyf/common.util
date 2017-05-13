/**
 * <p>项目名称:wms-utils</p>
 * <p>包名称:com.huimai.wms.util</p>
 * <p>文件名称:Utils.java</p>
 * <p>@since JDK1.7.0_79</p>
 * <p>@company 北京惠买在线科技有限公司
 * <p>@copyright Copyright(c) 2016
 * <p>=======文件描述=======</p>
 * <p></p>
 * <p>@author 杨文华</p>
 * <p>@date 2016年7月28日
 * <p>@version V1.0.0.0</p>
 */
package org.common.util.string;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.binary.Hex;
import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;

public class StringUtils {
	protected static final String EN_LOWER_STRING = "abcdefghijklmnopqrstuvwxyz";
	protected static final String EN_UPPER_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	protected static final String NU_STRING = "0123456789";
	protected static final String SP_STRING = "`~!@#$%^&*-_=+(),<.>/?\\;:'\"|";

	public static final String DATE_FORMATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String DATE_FORMATE_YYYYMMDD = "yyyyMMdd";
	public static final String DATE_FORMATE_HHMMSS = "HHmmss";
	public static final String DATE_FORMATE_YYYY_MM_DD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final char NOTHING_KEY_ENVENT = '_';
	/**
	 * 分隔符
	 */
	public static final String EPERGNE = "|";

	private static String han = "\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765\u4ed6\u8fd9\u4e0a\u7740\u4e2a\u5730\u5230\u5927\u91cc\u8bf4\u5c31\u53bb\u5b50\u5f97\u4e5f\u548c\u90a3\u8981\u4e0b\u770b\u5929\u65f6\u8fc7\u51fa\u5c0f\u4e48\u8d77\u4f60\u90fd\u628a\u597d\u8fd8\u591a\u6ca1\u4e3a\u53c8\u53ef\u5bb6\u5b66\u53ea\u4ee5\u4e3b\u4f1a\u6837\u5e74\u60f3\u751f\u540c\u8001\u4e2d\u5341\u4ece\u81ea\u9762\u524d\u5934\u9053\u5b83\u540e\u7136\u8d70\u5f88\u50cf\u89c1\u4e24\u7528\u5979\u56fd\u52a8\u8fdb\u6210\u56de\u4ec0\u8fb9\u4f5c\u5bf9\u5f00\u800c\u5df1\u4e9b\u73b0\u5c71\u6c11\u5019\u7ecf\u53d1\u5de5\u5411\u4e8b\u547d\u7ed9\u957f\u6c34\u51e0\u4e49\u4e09\u58f0\u4e8e\u9ad8\u624b\u77e5\u7406\u773c\u5fd7\u70b9\u5fc3\u6218\u4e8c\u95ee\u4f46\u8eab\u65b9\u5b9e\u5403\u505a\u53eb\u5f53\u4f4f\u542c\u9769\u6253\u5462\u771f\u5168\u624d\u56db\u5df2\u6240\u654c\u4e4b\u6700\u5149\u4ea7\u60c5\u8def\u5206\u603b\u6761\u767d\u8bdd\u4e1c\u5e2d\u6b21\u4eb2\u5982\u88ab\u82b1\u53e3\u653e\u513f\u5e38\u6c14\u4e94\u7b2c\u4f7f\u5199\u519b\u5427\u6587\u8fd0\u518d\u679c\u600e\u5b9a\u8bb8\u5feb\u660e\u884c\u56e0\u522b\u98de\u5916\u6811\u7269\u6d3b\u90e8\u95e8\u65e0\u5f80\u8239\u671b\u65b0\u5e26\u961f\u5148\u529b\u5b8c\u5374\u7ad9\u4ee3\u5458\u673a\u66f4\u4e5d\u60a8\u6bcf\u98ce\u7ea7\u8ddf\u7b11\u554a\u5b69\u4e07\u5c11\u76f4\u610f\u591c\u6bd4\u9636\u8fde\u8f66\u91cd\u4fbf\u6597\u9a6c\u54ea\u5316\u592a\u6307\u53d8\u793e\u4f3c\u58eb\u8005\u5e72\u77f3\u6ee1\u65e5\u51b3\u767e\u539f\u62ff\u7fa4\u7a76\u5404\u516d\u672c\u601d\u89e3\u7acb\u6cb3\u6751\u516b\u96be\u65e9\u8bba\u5417\u6839\u5171\u8ba9\u76f8\u7814\u4eca\u5176\u4e66\u5750\u63a5\u5e94\u5173\u4fe1\u89c9\u6b65\u53cd\u5904\u8bb0\u5c06\u5343\u627e\u4e89\u9886\u6216\u5e08\u7ed3\u5757\u8dd1\u8c01\u8349\u8d8a\u5b57\u52a0\u811a\u7d27\u7231\u7b49\u4e60\u9635\u6015\u6708\u9752\u534a\u706b\u6cd5\u9898\u5efa\u8d76\u4f4d\u5531\u6d77\u4e03\u5973\u4efb\u4ef6\u611f\u51c6\u5f20\u56e2\u5c4b\u79bb\u8272\u8138\u7247\u79d1\u5012\u775b\u5229\u4e16\u521a\u4e14\u7531\u9001\u5207\u661f\u5bfc\u665a\u8868\u591f\u6574\u8ba4\u54cd\u96ea\u6d41\u672a\u573a\u8be5\u5e76\u5e95\u6df1\u523b\u5e73\u4f1f\u5fd9\u63d0\u786e\u8fd1\u4eae\u8f7b\u8bb2\u519c\u53e4\u9ed1\u544a\u754c\u62c9\u540d\u5440\u571f\u6e05\u9633\u7167\u529e\u53f2\u6539\u5386\u8f6c\u753b\u9020\u5634\u6b64\u6cbb\u5317\u5fc5\u670d\u96e8\u7a7f\u5185\u8bc6\u9a8c\u4f20\u4e1a\u83dc\u722c\u7761\u5174\u5f62\u91cf\u54b1\u89c2\u82e6\u4f53\u4f17\u901a\u51b2\u5408\u7834\u53cb\u5ea6\u672f\u996d\u516c\u65c1\u623f\u6781\u5357\u67aa\u8bfb\u6c99\u5c81\u7ebf\u91ce\u575a\u7a7a\u6536\u7b97\u81f3\u653f\u57ce\u52b3\u843d\u94b1\u7279\u56f4\u5f1f\u80dc\u6559\u70ed\u5c55\u5305\u6b4c\u7c7b\u6e10\u5f3a\u6570\u4e61\u547c\u6027\u97f3\u7b54\u54e5\u9645\u65e7\u795e\u5ea7\u7ae0\u5e2e\u5566\u53d7\u7cfb\u4ee4\u8df3\u975e\u4f55\u725b\u53d6\u5165\u5cb8\u6562\u6389\u5ffd\u79cd\u88c5\u9876\u6025\u6797\u505c\u606f\u53e5\u533a\u8863\u822c\u62a5\u53f6\u538b\u6162\u53d4\u80cc\u7ec6";
	private static String base = "u7684u4e00u4e86u662fu6211u4e0du5728u4ebau4eecu6709u6765u4ed6u8fd9u4e0au7740u4e2au5730u5230u5927u91ccu8bf4u5c31u53bbu5b50u5f97u4e5fu548cu90a3u8981u4e0bu770bu5929u65f6u8fc7u51fau5c0fu4e48u8d77u4f60u90fdu628au597du8fd8u591au6ca1u4e3au53c8u53efu5bb6u5b66u53eau4ee5u4e3bu4f1au6837u5e74u60f3u751fu540cu8001u4e2du5341u4eceu81eau9762u524du5934u9053u5b83u540eu7136u8d70u5f88u50cfu89c1u4e24u7528u5979u56fdu52a8u8fdbu6210u56deu4ec0u8fb9u4f5cu5bf9u5f00u800cu5df1u4e9bu73b0u5c71u6c11u5019u7ecfu53d1u5de5u5411u4e8bu547du7ed9u957fu6c34u51e0u4e49u4e09u58f0u4e8eu9ad8u624bu77e5u7406u773cu5fd7u70b9u5fc3u6218u4e8cu95eeu4f46u8eabu65b9u5b9eu5403u505au53ebu5f53u4f4fu542cu9769u6253u5462u771fu5168u624du56dbu5df2u6240u654cu4e4bu6700u5149u4ea7u60c5u8defu5206u603bu6761u767du8bddu4e1cu5e2du6b21u4eb2u5982u88abu82b1u53e3u653eu513fu5e38u6c14u4e94u7b2cu4f7fu5199u519bu5427u6587u8fd0u518du679cu600eu5b9au8bb8u5febu660eu884cu56e0u522bu98deu5916u6811u7269u6d3bu90e8u95e8u65e0u5f80u8239u671bu65b0u5e26u961fu5148u529bu5b8cu5374u7ad9u4ee3u5458u673au66f4u4e5du60a8u6bcfu98ceu7ea7u8ddfu7b11u554au5b69u4e07u5c11u76f4u610fu591cu6bd4u9636u8fdeu8f66u91cdu4fbfu6597u9a6cu54eau5316u592au6307u53d8u793eu4f3cu58ebu8005u5e72u77f3u6ee1u65e5u51b3u767eu539fu62ffu7fa4u7a76u5404u516du672cu601du89e3u7acbu6cb3u6751u516bu96beu65e9u8bbau5417u6839u5171u8ba9u76f8u7814u4ecau5176u4e66u5750u63a5u5e94u5173u4fe1u89c9u6b65u53cdu5904u8bb0u5c06u5343u627eu4e89u9886u6216u5e08u7ed3u5757u8dd1u8c01u8349u8d8au5b57u52a0u811au7d27u7231u7b49u4e60u9635u6015u6708u9752u534au706bu6cd5u9898u5efau8d76u4f4du5531u6d77u4e03u5973u4efbu4ef6u611fu51c6u5f20u56e2u5c4bu79bbu8272u8138u7247u79d1u5012u775bu5229u4e16u521au4e14u7531u9001u5207u661fu5bfcu665au8868u591fu6574u8ba4u54cdu96eau6d41u672au573au8be5u5e76u5e95u6df1u523bu5e73u4f1fu5fd9u63d0u786eu8fd1u4eaeu8f7bu8bb2u519cu53e4u9ed1u544au754cu62c9u540du5440u571fu6e05u9633u7167u529eu53f2u6539u5386u8f6cu753bu9020u5634u6b64u6cbbu5317u5fc5u670du96e8u7a7fu5185u8bc6u9a8cu4f20u4e1au83dcu722cu7761u5174u5f62u91cfu54b1u89c2u82e6u4f53u4f17u901au51b2u5408u7834u53cbu5ea6u672fu996du516cu65c1u623fu6781u5357u67aau8bfbu6c99u5c81u7ebfu91ceu575au7a7au6536u7b97u81f3u653fu57ceu52b3u843du94b1u7279u56f4u5f1fu80dcu6559u70edu5c55u5305u6b4cu7c7bu6e10u5f3au6570u4e61u547cu6027u97f3u7b54u54e5u9645u65e7u795eu5ea7u7ae0u5e2eu5566u53d7u7cfbu4ee4u8df3u975eu4f55u725bu53d6u5165u5cb8u6562u6389u5ffdu79cdu88c5u9876u6025u6797u505cu606fu53e5u533au8863u822cu62a5u53f6u538bu6162u53d4u80ccu7ec6";

	public static String getUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String generateRandomString(int length, String... types) {
		if (length <= 0)
			return "";
		else if (types == null || types.length == 0) {
			types = new String[] { "en" };
		}

		StringBuffer sb = new StringBuffer();
		String srcStr = "";
		for (String type : types) {
			if (type.equalsIgnoreCase("en")) {
				srcStr += EN_LOWER_STRING + EN_UPPER_STRING;
			} else if (type.equalsIgnoreCase("nu")) {
				srcStr += NU_STRING;
			} else if (type.equalsIgnoreCase("sp")) {
				srcStr += SP_STRING;
			}
		}

		int srcStrLength = srcStr.length();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(srcStrLength);
			sb.append(srcStr.charAt(index));
		}
		return sb.toString();
	}

	public static String generatorRandomChineseString(int length) throws Exception {
		if (length <= 0)
			return "";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int highPos = (176 + Math.abs(random.nextInt(39)));
			int lowPos = 161 + Math.abs(random.nextInt(70));
			byte[] b = new byte[2];
			b[0] = (new Integer(highPos)).byteValue();
			b[1] = (new Integer(lowPos)).byteValue();
			String ch = "";
			ch = new String(new String(b, "GBK").getBytes(), "UTF-8");
			sb.append(ch);
		}

		return sb.toString();
	}

	public static String randomCineseString(int length) throws UnsupportedEncodingException {
		StringBuffer buffer = new StringBuffer();
		for (int j = 0; j < length; j++) {
			String ch = han.charAt(new Random().nextInt(han.length())) + "";
			buffer.append(ch);
		}
		return buffer.toString();
	}

	public static Object getValue(Object param, String field) throws Exception {
		if (param == null)
			return "";
		if (field == null || field.trim().equals(""))
			return "";
		if (param instanceof Map) {

			return ((Map<String, Object>) param).get(field);
		} else {
			// 否则使用get方法获取值
			String methodName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
			Method method = null;
			try {
				method = param.getClass().getMethod(methodName);
			} catch (NoSuchMethodException e) {
				throw new NoSuchMethodException("方法[" + methodName + "]未定义");
			}
			Object rtn = null;
			try {
				rtn = method.invoke(param);
			} catch (Exception e) {
				throw new Exception("执行方法[" + param.getClass().getName() + "." + methodName + "]时失败!");
			}
			return rtn;
		}
	}

	public static String $P_Replace(String regExpString, Map<String, String> mVariables, boolean is_sql) {
		if (regExpString == null || regExpString.trim().equals("")) {
			return regExpString;
		}
		if (mVariables == null || mVariables.isEmpty()) {
			return regExpString;
		}

		String regex = "\\$P\\{(?!\\$P\\{)[^\\}]*\\}";
		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(regExpString);

		while (matcher.find()) {
			String groupResult = matcher.group();
			String pKey = groupResult.substring(3, groupResult.length() - 1);
			String pVal = (mVariables.get(pKey) == null ? "" : mVariables.get(pKey));
			if (is_sql) {
				pVal = pVal.replaceAll("'", "''");
			}
			pVal = StringUtils.$P_Replace(pVal, mVariables, is_sql);
			if (pVal == null)
				pVal = "";
			regExpString = matcher.replaceFirst(Matcher.quoteReplacement(pVal));
			matcher = pattern.matcher(regExpString);
		}
		return regExpString;
	}

	public static String getMD5Value(String value, String key, String charsets) throws Exception {
		MessageDigest messageDigest = null;
		StringBuffer str = new StringBuffer();
		if (Strings.isNullOrEmpty(value)) {
			str.append(value);
		}
		if (Strings.isNullOrEmpty(value)) {
			str.append(key);
		}
		messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.reset();
		if (Strings.isNullOrEmpty(charsets)) {
			messageDigest.update(str.toString().getBytes(charsets));
		} else {
			messageDigest.update(str.toString().getBytes());
		}
		return Hex.encodeHexString(messageDigest.digest());
	}

	public static String inputStreamToString(InputStream is, String... charset) throws Exception {
		if (is == null)
			return null;
		byte tmpbyte[] = ByteStreams.toByteArray(is);
		if (charset != null && charset.length > 0) {
			return new String(tmpbyte, charset[0]);
		} else {
			return new String(tmpbyte);
		}
	}

	public static Object getValueFromMap(Map<String, Object> map, String pKey, Object defaultValue) {
		Object pVal = defaultValue == null ? "" : defaultValue;
		if (Strings.isNullOrEmpty(pKey))
			return pVal;
		else if (map == null || map.isEmpty())
			return pVal;
		else if (map.containsKey(pKey)) {
			return pVal;
		} else {
			pVal = map.get(pKey);
		}
		return pVal;
	}

	public static String $V_Replace(String regExpString, Object param, boolean is_sql) throws Exception {
		if (Strings.isNullOrEmpty(regExpString) || param == null) {
			return regExpString;
		}

		String regex = "\\$V\\{(?!\\$V\\{)[^\\}]*\\}";
		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(regExpString);

		while (matcher.find()) {
			String groupResult = matcher.group();
			String pKey = groupResult.substring(3, groupResult.length() - 1);
			String pVal = "";
			Object pVal1 = getValue(param, pKey);
			pVal = pVal == null ? "" : pVal1.toString();

			if (is_sql) {
				pVal = pVal.replaceAll("'", "''");
			}
			pVal = StringUtils.$V_Replace(pVal, param, is_sql);
			if (pVal == null)
				pVal = "";
			regExpString = matcher.replaceFirst(Matcher.quoteReplacement(pVal));
			matcher = pattern.matcher(regExpString);
		}
		return regExpString;
	}

	/**
	 * 转化为单精度浮点数 如果非数字默认为back
	 * 
	 * @param obj
	 * @param back
	 * @return
	 */
	public static float parseFloat(Object obj, float back) {
		float temp = back;

		String tempString = "";

		if (obj != null)
			tempString = obj.toString();

		try {
			temp = Float.parseFloat(tempString);
		} catch (Exception ee) {

		}

		return temp;
	}

	/**
	 * 转化为布尔值 如果非数字默认为back
	 * 
	 * @param obj
	 * @param back
	 * @return
	 */
	public static boolean parseBoolean01(Object obj, boolean back) {
		if (obj == null)
			obj = "";

		boolean temp = back;

		if (parseInt(obj, 0) == 1)
			temp = true;

		return temp;
	}

	/**
	 * 转化为整型 如果非数字默认为back
	 * 
	 * @param obj
	 * @param back
	 * @return
	 */
	public static int parseInt(Object obj, int back) {
		if (obj == null)
			obj = "";

		int temp = back;

		try {
			temp = Integer.parseInt(obj.toString());
		} catch (Exception ee) {

		}

		return temp;
	}

	/**
	 * 转化3个单精度浮点数 如果非数字默认为back
	 * 
	 * @param obj
	 * @param back
	 * @return
	 */
	public static float[] parseBlankFloat3(String string, float back) {
		float[] temp = { back, back, back };

		int blank1Index = -1, blank2Index = -1;
		blank1Index = string.indexOf(" ");
		temp[0] = parseFloat(string.substring(0, blank1Index), back);
		blank2Index = string.indexOf(" ", blank1Index + 1);
		temp[1] = parseFloat(string.substring(blank1Index, blank2Index), back);
		temp[2] = parseFloat(string.substring(blank2Index + 1), back);

		return temp;
	}

	/**
	 * 转化微调控制项值对象为单精度浮点数 如果非数字默认为back
	 * 
	 * @param spinnerObject
	 * @param back
	 * @return
	 */
	public static final float parseSpinnerValueToFloat(Object spinnerObject, float back) {
		float value = back;

		if (spinnerObject instanceof Integer) {
			value = ((Integer) spinnerObject).intValue();
		} else if (spinnerObject instanceof Double) {
			value = ((Double) spinnerObject).floatValue();
		} else if (spinnerObject instanceof Float) {
			value = ((Float) spinnerObject).floatValue();
		}

		return value;
	}

	/**
	 * 转化微调控制项值对象为正整数 如果非数字默认为back
	 * 
	 * @param spinnerObject
	 * @param back
	 * @return
	 */
	public static final int parseSpinnerValueToInt(Object spinnerObject, int back) {
		int value = (int) parseSpinnerValueToFloat(spinnerObject, back);

		return value;
	}

	/**
	 * 阻止空字符或者空字符串对象，产生异常
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static final String stopEmptyAndNull(Object obj) throws Exception {
		String ss = "";
		if (obj != null)
			ss = obj.toString();
		if (ss.length() == 0)
			throw new Exception();
		else
			return ss;
	}

	/**
	 * @deprecated
	 * @param as
	 * @param extStringList
	 * @return
	 */
	public static final boolean isTargetChar(String as, List<String> extStringList) {
		boolean result = false;

		String biah = as.trim();
		if (biah.length() == 0)
			return result;
		List<String> outStringList = new ArrayList<String>();
		outStringList.addAll(extStringList);

		for (int osli = 0; osli < outStringList.size(); osli++) {

		}

		return result;
	}

	/**
	 * 是否字母
	 * 
	 * @deprecated已过时
	 * @param as
	 * @param extStringList
	 * @return
	 */
	public static final boolean isZiMu(String as, List<String> extStringList) {
		List<String> extStringList2 = new ArrayList<String>();
		extStringList2.addAll(extStringList);

		return isTargetChar(as, extStringList2);
	}

	/**
	 * 字符串转化为网络格式 去除\n即回车换行
	 * 
	 * @param xmlString
	 * @return
	 */
	public static final String parseToNetway(String xmlString) {
		xmlString = xmlString.replaceAll("\n", "") + "\n";
		return xmlString;
	}

	/**
	 * 得到一个当然日期格式为年月日时分秒
	 * 
	 * @return
	 */
	public static final String showDatetime() {
		return dateFormate(DATE_FORMATE_YYYYMMDDHHMMSS);
	}

	/**
	 * 得到一个当然日期格式为年月日时分秒
	 * 
	 * @return
	 */
	public static final String showDatetimeCT() {
		return dateFormate(DATE_FORMATE_YYYY_MM_DD_HHMMSS);
	}

	/**
	 * 得到当前日期，格式为年月日 8位
	 * 
	 * @return
	 */
	public static final String showDate() {
		return dateFormate(DATE_FORMATE_YYYYMMDD);
	}

	/**
	 * 得到当前日期，格式为年月日 8位
	 * 
	 * @return
	 */
	public static final String showTime() {
		return dateFormate(DATE_FORMATE_HHMMSS);
	}

	/**
	 * 保证为2位， 一位的前面补0
	 * 
	 * @return
	 */
	private static final String en2(int en2) {
		String en2s = en2 + "";
		if (en2 < 10)
			en2s = "0" + en2;
		return en2s;
	}

	/**
	 * 字符串转化为ascii码数组
	 * 
	 * @param stringValue
	 * @return
	 */
	public static int[] stringToAsciiArray(String stringValue) {
		if (!Strings.isNullOrEmpty(stringValue)) {
			char[] asciiCharArray = stringValue.toCharArray();
			int[] asciiArray = new int[asciiCharArray.length];
			for (int i = 0; i < asciiCharArray.length; i++) {
				asciiArray[i] = asciiCharArray[i];
			}
			return asciiArray;
		}
		return null;

	}

	/**
	 * ascii码数组转化为字符串
	 * 
	 * @param asciiArray
	 * @return
	 */
	public static String asciiArrayToString(int[] asciiArray) {
		if (asciiArray != null && asciiArray.length > 0) {
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		for (int cai = 0; cai < asciiArray.length; cai++) {
			buffer.append((char) cai);
		}
		return buffer.toString();
	}

	public static int strToInt(String str) {
		return Strings.isNullOrEmpty(str) ? 0 : Integer.parseInt(str);
	}

	public static float formateDouble(String str, int multiple) {
		float db = Float.parseFloat(str);
		return db * multiple;
	}

	public static double formateDouble(double str, int multiple) {
		BigDecimal decimal = new BigDecimal(Double.toString(str));
		return decimal.multiply(new BigDecimal(multiple)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static int doubleStrtoInt(String str) {
		if (Strings.isNullOrEmpty(str)) {
			return doubletoInt(Double.parseDouble(str));
		}
		return 0;
	}

	public static int doubletoInt(double db) {
		Integer integer = new Integer((int) formateDouble(db, 100));
		BigInteger bi = new BigInteger(integer.toString());
		return bi.abs().intValue();
	}

	public static double formateDoubleDivided(String str, int sign) {
		if (Strings.isNullOrEmpty(str)) {
			return Integer.parseInt(str) * 0.01 * sign;
		} else {
			return 0.00;
		}
	}

	public static String getString(Object obj) {
		if (obj instanceof String) {
			return (String) obj;
		}
		return null;
	}

	public static String dateFormate(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	public static String dateFormate(String format) {
		GregorianCalendar gc = new GregorianCalendar();
		return dateFormate(gc.getTime(), format);
	}

}
