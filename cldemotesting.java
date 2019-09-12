
// *********************************************************************************************
//
// Automatically Generated Load Test Program
// -----------------------------------------
//
// Source: cldemotesting.java
// Date  : 09 Sep 2019 10:55:29 ECT
// Author: Apica ZebraTester V5.5-F / automatically generated
//
// Procedure Copyright by Ingenieurbuero David Fischer AG  |  A Company of the Apica Group
// All Rights Reserved
//
// http://www.apicasystem.com                                         http://www.zebratester.com
// *********************************************************************************************


import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.atomic.*;
import dfischer.utils.AbstractInputFileReader;
import dfischer.utils.Base64Decoder;
import dfischer.utils.Base64Encoder;
import dfischer.utils.ConvertToDoubleNumber;
import dfischer.utils.ContentTokenExtractor;
import dfischer.utils.ContentTokenExtractorItem;
import dfischer.utils.Cookie;
import dfischer.utils.CookieHandler;
import dfischer.utils.DigestAuthContext;
import dfischer.utils.DNSCache;
import dfischer.utils.DNSTranslationTable;
import dfischer.utils.DynamicProtobufContentParser;
import dfischer.utils.ExternalParamFile;
import dfischer.utils.FileCache;
import dfischer.utils.GenericPluginInterface;
import dfischer.utils.GetRealTimeUserInputFieldsInterface;
import dfischer.utils.HtmlContentParser;
import dfischer.utils.HtmlHeaderCookieExtractor;
import dfischer.utils.HttpLoadTest;
import dfischer.utils.HttpLoadTestIncrementUserThread;
import dfischer.utils.HttpLoadTestUserContext;
import dfischer.utils.HttpSocketPool;
import dfischer.utils.HttpTestURL;
import dfischer.utils.HttpTestURLDNSContext;
import dfischer.utils.HttpTestURLThreadHandler;
import dfischer.utils.InlineScriptExecutionException;
import dfischer.utils.InlineScriptExecutor;
import dfischer.utils.InnerLoopContext;
import dfischer.utils.JSONHtmlBasedExtractor;
import dfischer.utils.JSONPathBasedExtractor;
import dfischer.utils.JSONPathBasedExtractorItem;
import dfischer.utils.Lib;
import dfischer.utils.LoadtestInlineScriptContext;
import dfischer.utils.LoadtestInlineScriptVar;
import dfischer.utils.LoadtestPluginClassLoader;
import dfischer.utils.LoadtestPluginContext;
import dfischer.utils.NextProxyConfig;
import dfischer.utils.ParseArgs;
import dfischer.utils.ParseUrl;
import dfischer.utils.PerformanceData;
import dfischer.utils.PerformanceDataTickExtension;
import dfischer.utils.ProtobufFieldAndValueElement;
import dfischer.utils.ProtobufLib;
import dfischer.utils.RealTimeUserInputField;
import dfischer.utils.ScreenshotImage;
import dfischer.utils.SetThreadStepInterface;
import dfischer.utils.SSLInit;
import dfischer.utils.SSLSessionCacheStatistic;
import dfischer.utils.SSLSessionCacheStatisticInterface;
import dfischer.utils.SuspendResumeInterface;
import dfischer.utils.SymmetricEncrypt;
import dfischer.utils.SymmetricEncryptContext;
import dfischer.utils.TextLineTokenExtractor;
import dfischer.utils.TextLineTokenExtractorItem;
import dfischer.utils.ThreadStepInterface;
import dfischer.utils.UserInputField;
import dfischer.utils.UserTransactionContext;
import dfischer.utils.UserTransactionRuntimeHandler;
import dfischer.utils.VarInputFileReader;
import dfischer.utils.VarRandomInputFileReader;
import dfischer.utils.VaryingLoadInterface;
import dfischer.utils.VaryingTestDurationInterface;
import dfischer.utils.XmlContentParser;
import dfischer.utils.XmlDoctypeCommentParser;
import dfischer.utils.ZoneTime;
import dfischer.proxysniffer.ProxySnifferVarSourceInlineScript;
import dfischer.utils.WebSocketPluginInterface;
import dfischer.utils.BoundaryBasedExtractor;
import dfischer.utils.BoundaryBasedExtractorItem;
import dfischer.utils.RegExpBasedExtractor;
import dfischer.utils.RegExpBasedExtractorItem;
import dfischer.utils.XpathBasedExtractor;
import dfischer.utils.XpathBasedExtractorItem;
import dfischer.proxysniffer.WebSocketData;
import dfischer.utils.HttpTestWebsocketContext;
import dfischer.websocket.*;
import replay.ReplaySnapShotsDump;


/**
 * Automatically generated load test program.
 */
public class cldemotesting extends HttpLoadTest implements Runnable, ThreadStepInterface, SetThreadStepInterface, SSLSessionCacheStatisticInterface, VaryingLoadInterface, VaryingTestDurationInterface, SuspendResumeInterface, GetRealTimeUserInputFieldsInterface
{
	public static final String prxVersion = "V5.5-F";
	public static final int    prxCharEncoding = 3;                         // 1 = OS Default, 2 = ISO-8859-1, 3 = UTF-8
	public static final String testDescription = "";

	public static String USER_AGENT_1 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:68.0) Gecko/20100101 Firefox/68.0";

	private static final boolean CONTAINS_PARALLEL_EXECUTED_URLS = false;
	private static final int MAX_PARALLEL_THREADS_PER_USER = 6;                       // default value for max. parallel executed URLs per user
	private static int maxParallelThreadsPerUser = MAX_PARALLEL_THREADS_PER_USER;     // configured value for max. parallel executed URLs per user

	private static final boolean CONTAINS_EXTERNAL_RESOURCES = false;       // note: external resources are typically additional Java library files (*.jar files) invoked by self-developed plug-ins. Consider that Input Files and the Main Class of Plug-Ins are NOT external resources in this context because ZebraTester knows already their declarations.

	// --- WebSocket Object ---
	WebSocketData webSocketData = null;                                     // WebSocket Object that contains data of recorded WebSocket frames.
	WebSocketPluginInterface[] webSocketPluginsForURL = null;               // all assiciated web socket plugins for specific URL.

	// --- proxy configuration ---
	private static boolean proxyEnabled = false;                             // if false: do not use a proxy server
	private static boolean proxyCacheDisabled = true;
	private static String  proxyHttpHost = "";
	private static int     proxyHttpPort = -1;
	private static String  proxyHttpsHost = "";
	private static int     proxyHttpsPort = -1;
	private static String  noProxyFor = "";
	private static String  proxyAuthorization = null;
	private static NextProxyConfig commonNextProxyConfig = null;
	private NextProxyConfig userNextProxyConfig = null;
	
	private static int plannedStartupDelay = 200;                           // startup delay between concurrent users in milliseconds, see main argument "-sdelay"
	private static int plannedTestDuration = -1;                            // planned load test duration in seconds, 0 = unlimited, see main argument "-d"
	private static int maxPlannedLoops = 0;  								// maximum planned loops per user, 0 = unlimited, see main argument "-maxloops"
	private static int pacing = 0;  								        // pacing for loops per user, 0 = no pacing, see main argument "-pacing"
	private static long loopStartTime = 0;  								// start time of the main loop
	private static int plannedRequestTimeout = 0;                           // planned request timeout in seconds, see main argument "-t"
	private static int plannedConnectTimeout = 0;                           // planned TCP/IP socket connect timeout in seconds (default = use plannedRequestTimeout), see main argument "-tconnect"
	
	private static String defaultTimeZone = "ECT";                          // use main argument -tz <timezone> to alter
	private static char defaultNumberGroupingSeparator = '\'';              // use main argument -dgs a|c to alter
	private static String sslProtocolVersion = "all";                       // applied ssl protocol version: "all" = v3/tls/tls11/tls12, use main argument -ssl to set a fixed protocol version
	private static boolean sslcmode = false;                                // support of deficient ssl servers, use main argument -sslcmode to enable
	private static boolean sslECC = false;                                  // elliptic curve cryptography (ECC) is disabled by default, use main argument -ecc to enable
	private static boolean sslSNI = true;                                   // server name indication (SNI) is enabled by default, use main argument -nosni to disable
	private static boolean sslSNICirical = false;                           // the SNI TLS extension is by default set as non-critical, use main argument -snicritical to set as critical
	private static boolean useTlsSessionTickets = false;                    // Session Tickets can only be used with TLS, use main argument -tlssessiontickets to set to use
	private static final long loopErrorDelay = 20;                          // error delay (in milliseconds) applied if a loop of a virtual user has failed
	private static final String THREAD_NAME = "T000000";                    // internal
	private static Integer dumpLock = new Integer(0);                       // internal
	private static Integer inputFileLock = new Integer(0);                  // internal
	private volatile int threadStep = ThreadStepInterface.THREAD_NO_STEP;   // internal
	private boolean urlCallPassed = false;                                  // internal
	private String localIpAddress = null;                                   // internal
	private static long downlinkBandwidth = 0;                              // max. downlink bandwidth per user. 0 = unlimited. use main argument -downlink <kbps> to alter
	private static long uplinkBandwidth = 0;                                // max. uplink bandwidth per user. 0 = unlimited. use main argument -uplink <kbps> to alter
	private static boolean dnsPerLoop = false;								// true if main argument "-dnsperloop" is set = perform new DNS resolves for each executed loop. normally false
	private HttpTestURLDNSContext userDNSContext = null;                    // user specific DNS context - normally null when no special DNS servers are used
	
	private static volatile boolean debugFailedLoops = false;               // true if main argument "-dfl" is set
	private static volatile boolean debugLoops = false;                     // true if main argument "-dl" is set
	private static volatile boolean debugHttp = false;                      // true if main argument "-dh" is set
	private static volatile boolean debugContent = false;                   // true if main argument "-dc" is set
	private static volatile boolean debugCookies = false;                   // true if main argument "-dC" is set
	private static volatile boolean debugKeepAlive = false;                 // true if main argument "-dK" is set
	private static volatile boolean debugSsl = false;                       // true if main argument "-dssl" is set
	
	private static String resultFile = null;                                // name of binary test result file or null
	private static String browserLanguage = null;                           // name of browser language, argument -browserlang <text>
	private static boolean enableBrowserCache = false;                      // browser caching is disabled by default, use main argument -enablebrowcache to enable it
	private static boolean replayMode = false;                              // indicated the replay mode of the load test, use main argument -replay to enable it
	private long proxyDataRecordId;                                         // hold the record id for each recorded URL data
	
	private final static String httpProtocolVersion = "1.1";      // applied HTTP protocol version V1.1
	
	private static ExternalParamFile externalParamFile = null;                              // used only for very large parameter values (commonly unused)
	private static final String EXTERNAL_PARAM_FILE = "cldemotestingExtParams.dat";         // input file name for very large parameter values
	private static FileCache requestFileCache = new FileCache();  // file cache for large XML, SOAP and ASCII requests
	
	private int requestTimeout = -1;                              // thread input data from constructor, timeout per url request in seconds
	private int remainingLoops = -1;                              // thread input data from constructor, number of loops per thread (optional)
	private boolean checkLoopCount = false;                       // thread input data from constructor, number of loops per thread (optional)
	private int threadNumber = -1;                                // thread input data from constructor, internal thread number
	private int threadLoopCounter = 0;                            // internal loop counter per thread
	private volatile int userResumeStartWaitDelay = 0;            // internal, user specific delay when the load test execution is resumed
	private volatile boolean decrementEndOfLoopFlag = false;	  // internal flag to decrement the simulated user at runtime
	private volatile boolean incrementUserFlag = false;           // internal flag to increment the simulated user at runtime
	private volatile long incrementUserStartTime = -1;            // internal start time when increment the simulated user at runtime
	private static AtomicInteger totalLoopCounter = new AtomicInteger(0);    // internal overall loop counter

	private LoadtestPluginContext userPluginContext = null;       // plug-in context per user
	private LoadtestInlineScriptContext inlineScriptContext = null;          // re-used, scratch, the returned context of an inline script that runs at item or URL exec scope

	private Object sslSessionCache = null;                        // internal ssl session cache per thread
	private SSLSessionCacheStatistic sslStatistic = null;         // internal ssl session cache statistic per thread
	private static int sslSessionCacheTimeout = 300;              // timeout of ssl session cache in seconds, 0 = session cache disabled
	private static int sslHandshakeRandomGeneratorType = -1;      // invalid initial value, use the default secure random generator for SSL handshakes
	private HttpSocketPool socketPool = null;                     // re-used, scratch, internal socket pool per thread and loop
	private CookieHandler cookieHandler = null;                   // re-used, scratch, internal cookie handler per thread and loop

	private HttpTestURL testURL = null;                           // re-used, scratch, http request and response
	private HttpTestURLThreadHandler pageThreadHandler = null;    // re-used, scratch, support for parallel processing of http request within a page
	private int httpStatus = -1;                                  // re-used, scratch, http response status code from webserver
	private HtmlContentParser htmlContentParser = null;           // re-used, scratch, used to extract vars from http response
	private XmlContentParser xmlContentParser = null;             // re-used, scratch, used to extract vars from http response
	private JSONHtmlBasedExtractor jsonHtmlBasedExtractor = null; // re-used, scratch, used to extract vars from http response
	private DynamicProtobufContentParser protobufContentParser = null;  // re-used, scratch, used to extract vars from http response
	private TextLineTokenExtractor textLineTokenExtractor = null; // re-used, scratch, used to extract vars from http response
	private ContentTokenExtractor contentTokenExtractor = null;   // re-used, scratch, used to extract vars from http response
	private BoundaryBasedExtractor boundaryBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private RegExpBasedExtractor regExpBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private XpathBasedExtractor xpathBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private JSONPathBasedExtractor jsonPathBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	
	private volatile UserTransactionRuntimeHandler transactionHandler = new UserTransactionRuntimeHandler();		// re-used, support to manage user-defined transactions
	private Map<String,String> transactionContextMap = new HashMap<>();		// used to correctly measure the user-defined transactions

	private String vEVENTVALIDATION = null;              // var declaration from web admin var handler: scope = per loop
	private String vVIEWSTATE_3 = null;                  // var declaration from web admin var handler: scope = per loop
	private String vVIEWSTATE_2 = null;                  // var declaration from web admin var handler: scope = per loop
	private String vEVENTVALIDATION_1 = null;            // var declaration from web admin var handler: scope = per loop
	private String vVIEWSTATE_1 = null;                  // var declaration from web admin var handler: scope = per loop
	private String vPREVIOUSPAGE = null;                 // var declaration from web admin var handler: scope = per loop
	private String vVIEWSTATE = null;                    // var declaration from web admin var handler: scope = per loop
	private String vPREVIOUSPAGE_2 = null;               // var declaration from web admin var handler: scope = per loop
	private String vPREVIOUSPAGE_1 = null;               // var declaration from web admin var handler: scope = per loop
	
	/**
	 * constructor: called from load test plug-ins (scope = global).
	 */
	public cldemotesting()
	{
		super();
	}


	/**
	 * constructor: called when a user is created (per user).
	 */
	public cldemotesting(int maxLoops, int requestTimeout, int threadNumber)
	{
		super();
		this.requestTimeout = requestTimeout;
		this.remainingLoops = maxLoops;
		this.checkLoopCount = (maxLoops > 0);
		this.threadNumber = threadNumber;
		this.sslSessionCache = SSLInit.getNewSslSessionCache(sslSessionCacheTimeout);
		this.sslStatistic = new SSLSessionCacheStatistic();
		if (isMultihomed() && (!ipPerLoop()))
			this.localIpAddress = getNextMultihomedIpAddress();
		if (dnsCache != null)
			userDNSContext = new HttpTestURLDNSContext(dnsCache, threadNumber);
		
		applyNextProxySettingsFromFileIfExists();
		
		if (commonNextProxyConfig != null)
			// set proxy configuration data per user 
			userNextProxyConfig = new NextProxyConfig(commonNextProxyConfig);
		
		// initialize context for plug-ins which are executed per user
		userPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber);
		if(replayMode)
		{
			replaySnapShotsDump = new ReplaySnapShotsDump();
		}
	}


	/**
	 * internal method: called when a user starts a loop.
	 * contains the recorded session which is called by users x loops.
	 * 
	 * @param totalLoopCounter total number of loops (0..n-1) counted overall threads. This value is unique per loop.
	 * 
	 * @return  true:  loop successful completed.
	 *          false: loop failed.
	 */
	private boolean execute(int totalLoopCounter) throws Exception
	{
		markStartOfLoop();
		threadStep = 0;                 // internal - start loop at thread step 0
		
		// enable DNS resolves per loop?
		if (dnsPerLoop)
			userDNSContext = new HttpTestURLDNSContext(dnsCache.clone(false), threadNumber);
		
		// debug http headers?
		Object httpLogVectorObject = null;
		if (debugHttp)
			httpLogVectorObject = this;
		
		// create socket pool per loop
		sslSessionCache = SSLInit.getNewSslSessionCache(sslSessionCacheTimeout);		// reset the SSL session cache to get new SSL session IDs for this loop
		socketPool = new HttpSocketPool(this, sslProtocolVersion, sslSessionCache, sslStatistic, sslcmode);
		if (plannedConnectTimeout > 0)
			socketPool.setConnectTimeout(plannedConnectTimeout);
		if (sslHandshakeRandomGeneratorType != -1)
			socketPool.setSslHandshakeRandomGeneratorType(sslHandshakeRandomGeneratorType);
		socketPool.setSupportEllipticCurves(sslECC);
		socketPool.setHintUseSNI(sslSNI);
		socketPool.setSniCritical(sslSNICirical);
		socketPool.setUseTlsSessionTickets(useTlsSessionTickets);
		if (debugKeepAlive)
		{
			socketPool.setlogVectorObject(this);
			if (debugSsl)
				socketPool.enableSslLog();
		}
		
		if (downlinkBandwidth > 0)
			socketPool.setDownlinkBandwidth(downlinkBandwidth);
		if (uplinkBandwidth > 0)
			socketPool.setUplinkBandwidth(uplinkBandwidth);
		
		if (isMultihomed())
		{
			if (ipPerLoop())
				localIpAddress = getNextMultihomedIpAddress();
			socketPool.setClientIpAddress(localIpAddress);
			log();
			log("multihomed client ip address = " + localIpAddress);
		}
		
		// setup cookie handler per loop
		cookieHandler = new CookieHandler();
		if (debugCookies)
			cookieHandler.setLogVectorInterface(this);
		
		// customised vars from web admin var handler: scope = per loop
		htmlContentParser = null;
		xmlContentParser = null;
		jsonHtmlBasedExtractor = null;
		protobufContentParser = null;
		vEVENTVALIDATION = null;
		vVIEWSTATE_3 = null;
		vVIEWSTATE_2 = null;
		vEVENTVALIDATION_1 = null;
		vVIEWSTATE_1 = null;
		vPREVIOUSPAGE = null;
		vVIEWSTATE = null;
		vPREVIOUSPAGE_2 = null;
		vPREVIOUSPAGE_1 = null;
		log();
		log("<<< vEVENTVALIDATION = " + vEVENTVALIDATION);
		log("<<< vVIEWSTATE_3 = " + vVIEWSTATE_3);
		log("<<< vVIEWSTATE_2 = " + vVIEWSTATE_2);
		log("<<< vEVENTVALIDATION_1 = " + vEVENTVALIDATION_1);
		log("<<< vVIEWSTATE_1 = " + vVIEWSTATE_1);
		log("<<< vPREVIOUSPAGE = " + vPREVIOUSPAGE);
		log("<<< vVIEWSTATE = " + vVIEWSTATE);
		log("<<< vPREVIOUSPAGE_2 = " + vPREVIOUSPAGE_2);
		log("<<< vPREVIOUSPAGE_1 = " + vPREVIOUSPAGE_1);
		
		// initialize context for plug-ins which are executed per loop
		LoadtestPluginContext loopPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber, socketPool, cookieHandler);
		



		// --- VIRTUAL PAGE #0 ---
		if (!executePage_0(totalLoopCounter, loopPluginContext, new InnerLoopContext(), 0,0, httpLogVectorObject))
			return false;



		// --- PAGE BREAK: Test [0] ---
		log();
		log();
		log("# Page #1: Start Page");
		log("# -------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #1: Start Page", 0, 0, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_1_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_1_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_1_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 1 failed
		
		// page 1 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);
		
		
		// loop successful done
		// --------------------
		
		markEndOfPage(performanceData);
		
		endOfExecuteLoop(true, null, -1, loopPluginContext);
		log();
		return true;
	}		// end of execute()
		
		
		
	/**
	 * internal method: called when a user has completed a loop.
	 */
	private void endOfExecuteLoop(boolean loopPassed, HttpTestURL testURL, int threadStep, LoadtestPluginContext loopPluginContext) throws Exception
	{
		// log URL if last call has failed
		if ((!loopPassed) && (testURL != null))
			log(testURL);
		
		// update plugin context
		loopPluginContext.setLoopPassed(loopPassed);
		if ((testURL != null) && (loopPluginContext.getHttpTestURL() == null))
			loopPluginContext.setHttpTestURL(testURL);
		if ((threadStep != -1) && (loopPluginContext.getThreadStep() == -1))
			loopPluginContext.setThreadStep(threadStep);
	}


	/**
	 * Recorded http requests of page #0.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_0(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{

		// all http requests of page #0 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #1: Start Page
		// # -------------------



		// --- HTTP REQUEST: Test [1] <- WEB ADMIN Index 1 ---
		proxyDataRecordId =1564998902949L;
		String requestProt0001 = "http";
		String requestHost0001 = "cldemo.apicasystem.com";
		int    requestPort0001 = 0;
		String requestFile0001 = "/Styles/stylesheet.css";
		String requestHeader0001 = "GET " + requestFile0001 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com:0\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0001, requestHost0001, requestPort0001, requestHeader0001, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0001 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1996
		// content test algorithm: check size +/- 5%, defined content size = 1996
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 1996, 5);		// Test [1] <- Index 1
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [2] <- WEB ADMIN Index 2 ---
		proxyDataRecordId =1564998902958L;
		String requestProt0002 = "http";
		String requestHost0002 = "cldemo.apicasystem.com";
		int    requestPort0002 = 80;
		String requestFile0002 = "/WebResource.axd" +
				"?d=SwCcMWJbC5HPR0GyMZBQBtBVcjnGUcMopW87tvl8Uit8R50NU80PEVSNB0QE3yO4B2yncMJIGpp_qLe8p71gNcCZXqg1" +
				"&t=635195493660000000";
		String requestHeader0002 = "GET " + requestFile0002 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0002, requestHost0002, requestPort0002, requestHeader0002, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0002 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5770
		// content test algorithm: check size +/- 5%, defined content size = 5770
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 5770, 5);		// Test [2] <- Index 2
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [3] <- WEB ADMIN Index 3 ---
		proxyDataRecordId =1564998902959L;
		String requestProt0003 = "http";
		String requestHost0003 = "cldemo.apicasystem.com";
		int    requestPort0003 = 80;
		String requestFile0003 = "/Scripts/GoogleAnalytics.js";
		String requestHeader0003 = "GET " + requestFile0003 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0003, requestHost0003, requestPort0003, requestHeader0003, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0003 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 423
		// content test algorithm: check size +/- 5%, defined content size = 423
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 423, 5);		// Test [3] <- Index 3
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [4] <- WEB ADMIN Index 4 ---
		proxyDataRecordId =1564998902961L;
		String requestProt0004 = "http";
		String requestHost0004 = "cldemo.apicasystem.com";
		int    requestPort0004 = 80;
		String requestFile0004 = "/ScriptResource.axd" +
				"?d=h56yi9f0SB7seER6Wx2QkrhPtSLbAbmjWfLbxe6NnMKLKb_x1EczU3yqrSvXnNDzCA31HvjHi1zMywd_i_iEEcgT5k2GGUisXfZMzAapkPayWJ9AxbjDAAGN2939G6RmvTumPfamqanP4KrFXzPHlSA3kqBCx7sCGYHewvdUTT0C-MtS0" +
				"&t=ca758f3";
		String requestHeader0004 = "GET " + requestFile0004 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0004, requestHost0004, requestPort0004, requestHeader0004, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0004 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 25604
		// content test algorithm: check size +/- 5%, defined content size = 25604
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 25604, 5);		// Test [4] <- Index 4
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [5] <- WEB ADMIN Index 5 ---
		proxyDataRecordId =1564998902964L;
		String requestProt0005 = "http";
		String requestHost0005 = "cldemo.apicasystem.com";
		int    requestPort0005 = 80;
		String requestFile0005 = "/ScriptResource.axd" +
				"?d=pF1UDEgDL-2LZwQfO6oW8b5wup5ZTmRNHIIKGMEg7qKDcL2x4ExDoDjg0E8z3OvGe2w9EPoQYsum-y_KtzjGbPMaWSf7JE_TIeSMo4-aeyM5O68PbG2PnQA031vNZ3k7GOtQNGdd6urpXo2j_XbTbRcZAtwb36HBbokBnkQqexUHSfjE0" +
				"&t=ca758f3";
		String requestHeader0005 = "GET " + requestFile0005 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0005, requestHost0005, requestPort0005, requestHeader0005, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0005 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 9984
		// content test algorithm: check size +/- 5%, defined content size = 9984
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 9984, 5);		// Test [5] <- Index 5
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [6] <- WEB ADMIN Index 6 ---
		proxyDataRecordId =1564998902978L;
		String requestProt0006 = "http";
		String requestHost0006 = "cldemo.apicasystem.com";
		int    requestPort0006 = 80;
		String requestFile0006 = "/Images/Banners/WindowsAzure.jpg";
		String requestHeader0006 = "GET " + requestFile0006 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0006, requestHost0006, requestPort0006, requestHeader0006, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0006 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 1238
		// content test algorithm: check size +/- 5%, defined content size = 1238
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 1238, 5);		// Test [6] <- Index 6
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [7] <- WEB ADMIN Index 7 ---
		proxyDataRecordId =1564998902979L;
		String requestProt0007 = "http";
		String requestHost0007 = "cldemo.apicasystem.com";
		int    requestPort0007 = 80;
		String requestFile0007 = "/Images/Banners/Amazon.jpg";
		String requestHeader0007 = "GET " + requestFile0007 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0007, requestHost0007, requestPort0007, requestHeader0007, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0007 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 918
		// content test algorithm: check size +/- 5%, defined content size = 918
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 918, 5);		// Test [7] <- Index 7
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [8] <- WEB ADMIN Index 8 ---
		proxyDataRecordId =1564998902995L;
		String requestProt0008 = "http";
		String requestHost0008 = "cldemo.apicasystem.com";
		int    requestPort0008 = 80;
		String requestFile0008 = "/Images/logo.png";
		String requestHeader0008 = "GET " + requestFile0008 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0008, requestHost0008, requestPort0008, requestHeader0008, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0008 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 6391
		// content test algorithm: check size +/- 5%, defined content size = 6391
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 6391, 5);		// Test [8] <- Index 8
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [9] <- WEB ADMIN Index 9 ---
		proxyDataRecordId =1564998902997L;
		String requestProt0009 = "http";
		String requestHost0009 = "cldemo.apicasystem.com";
		int    requestPort0009 = 80;
		String requestFile0009 = "/Images/Banners/Bullet.png";
		String requestHeader0009 = "GET " + requestFile0009 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0009, requestHost0009, requestPort0009, requestHeader0009, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0009 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 405
		// content test algorithm: check size +/- 5%, defined content size = 405
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 405, 5);		// Test [9] <- Index 9
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [10] <- WEB ADMIN Index 10 ---
		proxyDataRecordId =1564998903002L;
		String requestProt0010 = "http";
		String requestHost0010 = "cldemo.apicasystem.com";
		int    requestPort0010 = 80;
		String requestFile0010 = "/Images/Banners/WindowsServer.jpg";
		String requestHeader0010 = "GET " + requestFile0010 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0010, requestHost0010, requestPort0010, requestHeader0010, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0010 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 1408
		// content test algorithm: check size +/- 5%, defined content size = 1408
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 1408, 5);		// Test [10] <- Index 10
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [11] <- WEB ADMIN Index 11 ---
		proxyDataRecordId =1564998903003L;
		String requestProt0011 = "http";
		String requestHost0011 = "cldemo.apicasystem.com";
		int    requestPort0011 = 80;
		String requestFile0011 = "/Images/Banners/Lamp.jpg";
		String requestHeader0011 = "GET " + requestFile0011 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0011, requestHost0011, requestPort0011, requestHeader0011, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0011 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 870
		// content test algorithm: check size +/- 5%, defined content size = 870
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 870, 5);		// Test [11] <- Index 11
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [12] <- WEB ADMIN Index 12 ---
		proxyDataRecordId =1564998903005L;
		String requestProt0012 = "http";
		String requestHost0012 = "cldemo.apicasystem.com";
		int    requestPort0012 = 80;
		String requestFile0012 = "/Images/cart.png";
		String requestHeader0012 = "GET " + requestFile0012 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0012, requestHost0012, requestPort0012, requestHeader0012, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0012 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 423
		// content test algorithm: check size +/- 5%, defined content size = 423
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 423, 5);		// Test [12] <- Index 12
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [13] <- WEB ADMIN Index 13 ---
		proxyDataRecordId =1564998903020L;
		String requestProt0013 = "http";
		String requestHost0013 = "cldemo.apicasystem.com";
		int    requestPort0013 = 80;
		String requestFile0013 = "/Images/Logos/azure.png";
		String requestHeader0013 = "GET " + requestFile0013 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0013, requestHost0013, requestPort0013, requestHeader0013, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0013 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 4964
		// content test algorithm: check size +/- 5%, defined content size = 4964
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 4964, 5);		// Test [13] <- Index 13
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [14] <- WEB ADMIN Index 14 ---
		proxyDataRecordId =1564998903022L;
		String requestProt0014 = "http";
		String requestHost0014 = "cldemo.apicasystem.com";
		int    requestPort0014 = 80;
		String requestFile0014 = "/Images/ChLeagueFour.JPG";
		String requestHeader0014 = "GET " + requestFile0014 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0014, requestHost0014, requestPort0014, requestHeader0014, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0014 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 60220
		// content test algorithm: check size +/- 5%, defined content size = 60220
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 60220, 5);		// Test [14] <- Index 14
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [15] <- WEB ADMIN Index 15 ---
		proxyDataRecordId =1564998903024L;
		String requestProt0015 = "http";
		String requestHost0015 = "cldemo.apicasystem.com";
		int    requestPort0015 = 80;
		String requestFile0015 = "/Images/img.jpg";
		String requestHeader0015 = "GET " + requestFile0015 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0015, requestHost0015, requestPort0015, requestHeader0015, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0015 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 46192
		// content test algorithm: check size +/- 5%, defined content size = 46192
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 46192, 5);		// Test [15] <- Index 15
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [16] <- WEB ADMIN Index 16 ---
		proxyDataRecordId =1564998903034L;
		String requestProt0016 = "http";
		String requestHost0016 = "cldemo.apicasystem.com";
		int    requestPort0016 = 80;
		String requestFile0016 = "/images/bg.jpg";
		String requestHeader0016 = "GET " + requestFile0016 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0016, requestHost0016, requestPort0016, requestHeader0016, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0016 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 130542
		// content test algorithm: check size +/- 5%, defined content size = 130542
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 130542, 5);		// Test [16] <- Index 16
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [17] <- WEB ADMIN Index 17 ---
		proxyDataRecordId =1564998903084L;
		String requestProt0017 = "http";
		String requestHost0017 = "cldemo.apicasystem.com";
		int    requestPort0017 = 80;
		String requestFile0017 = "/font/myriadpro-regular_4-webfont.ttf";
		String requestHeader0017 = "GET " + requestFile0017 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0017, requestHost0017, requestPort0017, requestHeader0017, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0017 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 49392
		// content test algorithm: check size +/- 5%, defined content size = 49392
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/OCTET-STREAM", null, 49392, 5);		// Test [17] <- Index 17
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [18] <- WEB ADMIN Index 18 ---
		proxyDataRecordId =1564998903123L;
		String requestProt0018 = "http";
		String requestHost0018 = "cldemo.apicasystem.com";
		int    requestPort0018 = 80;
		String requestFile0018 = "/font/myriadpro-semibold_6-webfont.ttf";
		String requestHeader0018 = "GET " + requestFile0018 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0018, requestHost0018, requestPort0018, requestHeader0018, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0018 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 48268
		// content test algorithm: check size +/- 5%, defined content size = 48268
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/OCTET-STREAM", null, 48268, 5);		// Test [18] <- Index 18
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [19] <- WEB ADMIN Index 19 ---
		proxyDataRecordId =1564998903125L;
		String requestProt0019 = "http";
		String requestHost0019 = "cldemo.apicasystem.com";
		int    requestPort0019 = 80;
		String requestFile0019 = "/Images/white_banner_900x25.png";
		String requestHeader0019 = "GET " + requestFile0019 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0019, requestHost0019, requestPort0019, requestHeader0019, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0019 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1446
		// content test algorithm: check size +/- 5%, defined content size = 1446
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1446, 5);		// Test [19] <- Index 19
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [20] <- WEB ADMIN Index 20 ---
		proxyDataRecordId =1564998903130L;
		String requestProt0020 = "http";
		String requestHost0020 = "cldemo.apicasystem.com";
		int    requestPort0020 = 80;
		String requestFile0020 = "/images/headbg.png";
		String requestHeader0020 = "GET " + requestFile0020 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0020, requestHost0020, requestPort0020, requestHeader0020, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0020 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 234
		// content test algorithm: check size +/- 5%, defined content size = 234
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 234, 5);		// Test [20] <- Index 20
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1_1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #1 (fragment 2 of 4)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [21] <- WEB ADMIN Index 21 ---
		proxyDataRecordId =1564998903131L;
		String requestProt0021 = "http";
		String requestHost0021 = "cldemo.apicasystem.com";
		int    requestPort0021 = 80;
		String requestFile0021 = "/images/header_left.png";
		String requestHeader0021 = "GET " + requestFile0021 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0021, requestHost0021, requestPort0021, requestHeader0021, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0021 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 346
		// content test algorithm: check size +/- 5%, defined content size = 346
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 346, 5);		// Test [21] <- Index 21
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [22] <- WEB ADMIN Index 22 ---
		proxyDataRecordId =1564998903132L;
		String requestProt0022 = "http";
		String requestHost0022 = "cldemo.apicasystem.com";
		int    requestPort0022 = 80;
		String requestFile0022 = "/images/navleft_h.png";
		String requestHeader0022 = "GET " + requestFile0022 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0022, requestHost0022, requestPort0022, requestHeader0022, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0022 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 254
		// content test algorithm: check size +/- 5%, defined content size = 254
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 254, 5);		// Test [22] <- Index 22
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [23] <- WEB ADMIN Index 23 ---
		proxyDataRecordId =1564998903133L;
		String requestProt0023 = "http";
		String requestHost0023 = "cldemo.apicasystem.com";
		int    requestPort0023 = 80;
		String requestFile0023 = "/images/navright_h.png";
		String requestHeader0023 = "GET " + requestFile0023 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0023, requestHost0023, requestPort0023, requestHeader0023, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0023 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 183
		// content test algorithm: check size +/- 5%, defined content size = 183
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 183, 5);		// Test [23] <- Index 23
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [24] <- WEB ADMIN Index 24 ---
		proxyDataRecordId =1564998903134L;
		String requestProt0024 = "http";
		String requestHost0024 = "cldemo.apicasystem.com";
		int    requestPort0024 = 80;
		String requestFile0024 = "/images/navright.png";
		String requestHeader0024 = "GET " + requestFile0024 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0024, requestHost0024, requestPort0024, requestHeader0024, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0024 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 192
		// content test algorithm: check size +/- 5%, defined content size = 192
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 192, 5);		// Test [24] <- Index 24
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [25] <- WEB ADMIN Index 25 ---
		proxyDataRecordId =1564998903141L;
		String requestProt0025 = "http";
		String requestHost0025 = "cldemo.apicasystem.com";
		int    requestPort0025 = 80;
		String requestFile0025 = "/images/navleft.png";
		String requestHeader0025 = "GET " + requestFile0025 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0025, requestHost0025, requestPort0025, requestHeader0025, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0025 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 271
		// content test algorithm: check size +/- 5%, defined content size = 271
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 271, 5);		// Test [25] <- Index 25
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [26] <- WEB ADMIN Index 26 ---
		proxyDataRecordId =1564998903169L;
		String requestProt0026 = "http";
		String requestHost0026 = "cldemo.apicasystem.com";
		int    requestPort0026 = 80;
		String requestFile0026 = "/images/header_right.png";
		String requestHeader0026 = "GET " + requestFile0026 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0026, requestHost0026, requestPort0026, requestHeader0026, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0026 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 272
		// content test algorithm: check size +/- 5%, defined content size = 272
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 272, 5);		// Test [26] <- Index 26
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [27] <- WEB ADMIN Index 27 ---
		proxyDataRecordId =1564998903171L;
		String requestProt0027 = "http";
		String requestHost0027 = "cldemo.apicasystem.com";
		int    requestPort0027 = 80;
		String requestFile0027 = "/images/right_banner.jpg";
		String requestHeader0027 = "GET " + requestFile0027 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0027, requestHost0027, requestPort0027, requestHeader0027, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0027 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 8180
		// content test algorithm: check size +/- 5%, defined content size = 8180
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 8180, 5);		// Test [27] <- Index 27
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [28] <- WEB ADMIN Index 28 ---
		proxyDataRecordId =1564998903183L;
		String requestProt0028 = "http";
		String requestHost0028 = "cldemo.apicasystem.com";
		int    requestPort0028 = 80;
		String requestFile0028 = "/images/footer_mid.png";
		String requestHeader0028 = "GET " + requestFile0028 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0028, requestHost0028, requestPort0028, requestHeader0028, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0028 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 212
		// content test algorithm: check size +/- 5%, defined content size = 212
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 212, 5);		// Test [28] <- Index 28
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [29] <- WEB ADMIN Index 29 ---
		proxyDataRecordId =1564998903184L;
		String requestProt0029 = "http";
		String requestHost0029 = "cldemo.apicasystem.com";
		int    requestPort0029 = 80;
		String requestFile0029 = "/images/footer_left.png";
		String requestHeader0029 = "GET " + requestFile0029 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0029, requestHost0029, requestPort0029, requestHeader0029, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0029 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 445
		// content test algorithm: check size +/- 5%, defined content size = 445
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 445, 5);		// Test [29] <- Index 29
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [30] <- WEB ADMIN Index 30 ---
		proxyDataRecordId =1564998903185L;
		String requestProt0030 = "http";
		String requestHost0030 = "cldemo.apicasystem.com";
		int    requestPort0030 = 80;
		String requestFile0030 = "/images/footer_right.png";
		String requestHeader0030 = "GET " + requestFile0030 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0030, requestHost0030, requestPort0030, requestHeader0030, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0030 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 427
		// content test algorithm: check size +/- 5%, defined content size = 427
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 427, 5);		// Test [30] <- Index 30
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [31] <- WEB ADMIN Index 33 ---
		proxyDataRecordId =1564998905777L;
		log();
		log("# title: All tickets");
		String requestProt0031 = "http";
		String requestHost0031 = "cldemo.apicasystem.com";
		int    requestPort0031 = 80;
		String requestFile0031 = "/AllTickets.aspx";
		String requestHeader0031 = "GET " + requestFile0031 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0031, requestHost0031, requestPort0031, requestHeader0031, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0031 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 6258
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "option value=\"FC Internazionale Milano\"");		// Test [31] <- Index 31
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'vPREVIOUSPAGE'
			vPREVIOUSPAGE = htmlContentParser.getFormTable().getForm(0).getFormItemValue("__PREVIOUSPAGE");		// recorded value = ZLR5YJNgG_28z3wT_GJVe5VIuhNO4AuAkO5rVgyrhVAbfEkZAmZsfgGhmkjyFFgJp_-2Gi9syvmlGt14SlVDfS6S4XQ4ds_n1K_mI_0jsbSSOGHC0
			log("<<< vPREVIOUSPAGE = " + vPREVIOUSPAGE);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && vPREVIOUSPAGE!= null && vPREVIOUSPAGE.trim().length() == 0)
			{
				vPREVIOUSPAGE = "";
				log("runtime note: the extraction of a new value for the variable 'vPREVIOUSPAGE' ends up with an empty string - a substitute value was set");
				log("<<< vPREVIOUSPAGE = " + vPREVIOUSPAGE);
			}
		}
		catch (Exception e) { vPREVIOUSPAGE = null; log(e); }
		if (vPREVIOUSPAGE == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vPREVIOUSPAGE' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vVIEWSTATE'
			vVIEWSTATE = htmlContentParser.getFormTable().getForm(0).getFormItemValue("__VIEWSTATE");		// recorded value = NCsYcSoiCo1ZKQ7vdj57rwsHTAKrlEUgfb8D0msMgZFUWrb+/lBeGkXa9MgrpMtxrXl0nwYcYAjEcoByB15jwfmcYo4cv4EDJHOUBJKTyfFVUNANl8ihhNbiMkrXn8hsJ0j1YHSeY3K8xI6jkIXQXr/CR4VqaPPTdddZHOS7MnZ9WGXSfxNM7MMGN4DLEKvJjKV5C+9EuN2KRt6MBFOXA0X1JJ3Wi8oI+cqjJiJWsBjYsKzEmiDdDKcoGSSkhlYrBnL7zQg5HdLAnOS2SwRj/Rt+fTVnnx5K75I5ub5+wMdm/otgk+Fm4ROwNIYBg8HXW9qYWlnSspwKL42unRH2u5e197iWjscWgQoG6/95tmGIQA/QusY2CwABk8kqU2ohakpkzmnT8jnXfvAgrmPX8TWeMlANW3Ey4vFP/lIqFBZ2j5+soaPMU6WlValSQkXNfNNvulEs+QdIF8ep4cUAR4tKpLqdwwg9vrWaBaG+Gj9pn+ShlfJqVeXcgCvi/zmoDQBncwkXNYI1WS1xK+txAQJyMh3kwtC9Twk3ADZZcV1amoO2EX0Nnb1wlIBwmp2AuDoyZTRAjhghGqzVa6VNmVxIf6m0lmu2fnrHLUmwGBsnbmwrKQl+9h9xxUezBEn6FV4P5Ay+aIQ9yIiIXsHMLncKGUQXi0U4kEFV3dUKoXG1Eic5Z+lzpqpur2E7QyvYPqmcnZlW3eQv3Isgzy8mFxviD9j1j2SpQ9eHLJDZjDya6vqnh335CDQ0+iHDNK7uJFHjaFlg2QUMG9h/Af3DZC85jQf1UB3Z9BougYxLls+737/9HylXm33Ph1tDr9JTxZ6NeWzvgi2ej7O/LOtlGz6OhRz/Mqzk3xdSY0M6jRsFP6a4/ITQjUD3lewnbk6DJtNenH4iM0T5ptfNMJnTU5n2Z805OvlG7ZrI6UusKudSHswQ5pTflGOIABLRuuedj8YRdQj9nC/QH00ntE18KRIhYoEmz6074idaRJIZNovVhZTjUXx4Om9QNnEuglvBMelk11AxIlvBx4KcPxgM4Ti1IVsmVXIdq07NcAQvcNOmm1AeOD3V3I5SNqzEW4+3Ijo2k9If+PIGFxOHDP+wxdi+Cl3TyGxXSUGhE47LLCDcYv0uP+6i1w9ybTdTpd/hLonMBw2qVHywMooZgWK16xpYfR0n0j7U5twXHxd1h9MoY1+vIKNoqkKMQSJfFw4QJ1k5nT/kBJJ9v1moVVrx1RH8BDixTDgjX7zZhY4H40lxcT6zywf4K1/T+AZY8asUd0IAZTWi/2hKEWFTPzk/RrFBa93z6TrLZEv3wZowRZ3qsf7IVN9xNUEfBsZ230m0fwIEHxF1U7tqF2jjshZa4GX+oPltsjQ2mkaN1wlba31gr2ZPww+DKNv/n7AXPfBQyRKl9neyOoX+8Tnodn9XZrv/NO8ZaZZ/GpbrKFVzKvhLbhdcOU64WUEUJaGmNQoSdqd+yR3cK5nyAzA/YeAqISlJbsDpTv5xY6YRXrmkB0gHSdo6bOEIcORfjc4IfMnh3Q5luJ5Zaew2nIbDz/chjTzUiMMIEsg7UhmDzZe/FiRDX7uQywOc98Ri59XEyBoV3LytBbILbWFas34LZmmI4yXCBPpvXpJlGz3l4WyIgmdhMvO80zB9tJQsZE6G2l936XIGlzC4O8KODK0d0tbG5vijcbl5awTSJN7icevxXUduv1SsQ9kGQkYXRkz+ZF9fMs9sUS71qZ8WcvuUneEGn3Q04ITX5m19HB0SbO6Sl+BpV9WLhfh10omfF1ib6byXKrjciCuHwDp5yIWrw9FsAds2ImKV8zjdPc47VajY+xy1bTKLGmxRBahhr83zeOxmaP12HJC0PDGvtZzOMSfrNb2s+zQ=
			log("<<< vVIEWSTATE = " + vVIEWSTATE);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && vVIEWSTATE!= null && vVIEWSTATE.trim().length() == 0)
			{
				vVIEWSTATE = "";
				log("runtime note: the extraction of a new value for the variable 'vVIEWSTATE' ends up with an empty string - a substitute value was set");
				log("<<< vVIEWSTATE = " + vVIEWSTATE);
			}
		}
		catch (Exception e) { vVIEWSTATE = null; log(e); }
		if (vVIEWSTATE == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vVIEWSTATE' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [32] <- WEB ADMIN Index 34 ---
		proxyDataRecordId =1564998905857L;
		String requestProt0032 = "http";
		String requestHost0032 = "cldemo.apicasystem.com";
		int    requestPort0032 = 80;
		String requestFile0032 = "/Images/Wait/spining_wheel_notrans.gif";
		String requestHeader0032 = "GET " + requestFile0032 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0032, requestHost0032, requestPort0032, requestHeader0032, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0032 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 6337
		// content test algorithm: check size +/- 5%, defined content size = 6337
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 6337, 5);		// Test [32] <- Index 32
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [33] <- WEB ADMIN Index 35 ---
		proxyDataRecordId =1564998905911L;
		String requestProt0033 = "http";
		String requestHost0033 = "cldemo.apicasystem.com";
		int    requestPort0033 = 80;
		String requestFile0033 = "/images/green_button.gif";
		String requestHeader0033 = "GET " + requestFile0033 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0033, requestHost0033, requestPort0033, requestHeader0033, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0033 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 154
		// content test algorithm: check size +/- 5%, defined content size = 154
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 154, 5);		// Test [33] <- Index 33
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [34] <- WEB ADMIN Index 37 ---
		proxyDataRecordId =1564998907457L;
		String requestProt0034 = "http";
		String requestHost0034 = "cldemo.apicasystem.com";
		int    requestPort0034 = 80;
		String requestFile0034 = "/AllTickets.aspx";
		String requestContent0034 = 
				"ctl00%24ScriptManager1=ctl00%24ScriptManager1%7Cctl00%24MainContent%24CheckGamesButton" +
				"&__EVENTTARGET=" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=NCsYcSoiCo1ZKQ7vdj57rwsHTAKrlEUgfb8D0msMgZFUWrb%2B%2FlBeGkXa9MgrpMtxrXl0nwYcYAjEcoByB15jwfmcYo4cv4EDJHOUBJKTyfFVUNANl8ihhNbiMkrXn8hsJ0j1YHSeY3K8xI6jkIXQXr%2FCR4VqaPPTdddZHOS7MnZ9WGXSfxNM7MMGN4DLEKvJjKV5C%2B9EuN2KRt6MBFOXA0X1JJ3Wi8oI%2BcqjJiJWsBjYsKzEmiDdDKcoGSSkhlYrBnL7zQg5HdLAnOS2SwRj%2FRt%2BfTVnnx5K75I5ub5%2BwMdm%2Fotgk%2BFm4ROwNIYBg8HXW9qYWlnSspwKL42unRH2u5e197iWjscWgQoG6%2F95tmGIQA%2FQusY2CwABk8kqU2ohakpkzmnT8jnXfvAgrmPX8TWeMlANW3Ey4vFP%2FlIqFBZ2j5%2BsoaPMU6WlValSQkXNfNNvulEs%2BQdIF8ep4cUAR4tKpLqdwwg9vrWaBaG%2BGj9pn%2BShlfJqVeXcgCvi%2FzmoDQBncwkXNYI1WS1xK%2BtxAQJyMh3kwtC9Twk3ADZZcV1amoO2EX0Nnb1wlIBwmp2AuDoyZTRAjhghGqzVa6VNmVxIf6m0lmu2fnrHLUmwGBsnbmwrKQl%2B9h9xxUezBEn6FV4P5Ay%2BaIQ9yIiIXsHMLncKGUQXi0U4kEFV3dUKoXG1Eic5Z%2Blzpqpur2E7QyvYPqmcnZlW3eQv3Isgzy8mFxviD9j1j2SpQ9eHLJDZjDya6vqnh335CDQ0%2BiHDNK7uJFHjaFlg2QUMG9h%2FAf3DZC85jQf1UB3Z9BougYxLls%2B737%2F9HylXm33Ph1tDr9JTxZ6NeWzvgi2ej7O%2FLOtlGz6OhRz%2FMqzk3xdSY0M6jRsFP6a4%2FITQjUD3lewnbk6DJtNenH4iM0T5ptfNMJnTU5n2Z805OvlG7ZrI6UusKudSHswQ5pTflGOIABLRuuedj8YRdQj9nC%2FQH00ntE18KRIhYoEmz6074idaRJIZNovVhZTjUXx4Om9QNnEuglvBMelk11AxIlvBx4KcPxgM4Ti1IVsmVXIdq07NcAQvcNOmm1AeOD3V3I5SNqzEW4%2B3Ijo2k9If%2BPIGFxOHDP%2Bwxdi%2BCl3TyGxXSUGhE47LLCDcYv0uP%2B6i1w9ybTdTpd%2FhLonMBw2qVHywMooZgWK16xpYfR0n0j7U5twXHxd1h9MoY1%2BvIKNoqkKMQSJfFw4QJ1k5nT%2FkBJJ9v1moVVrx1RH8BDixTDgjX7zZhY4H40lxcT6zywf4K1%2FT%2BAZY8asUd0IAZTWi%2F2hKEWFTPzk%2FRrFBa93z6TrLZEv3wZowRZ3qsf7IVN9xNUEfBsZ230m0fwIEHxF1U7tqF2jjshZa4GX%2BoPltsjQ2mkaN1wlba31gr2ZPww%2BDKNv%2Fn7AXPfBQyRKl9neyOoX%2B8Tnodn9XZrv%2FNO8ZaZZ%2FGpbrKFVzKvhLbhdcOU64WUEUJaGmNQoSdqd%2ByR3cK5nyAzA%2FYeAqISlJbsDpTv5xY6YRXrmkB0gHSdo6bOEIcORfjc4IfMnh3Q5luJ5Zaew2nIbDz%2FchjTzUiMMIEsg7UhmDzZe%2FFiRDX7uQywOc98Ri59XEyBoV3LytBbILbWFas34LZmmI4yXCBPpvXpJlGz3l4WyIgmdhMvO80zB9tJQsZE6G2l936XIGlzC4O8KODK0d0tbG5vijcbl5awTSJN7icevxXUduv1SsQ9kGQkYXRkz%2BZF9fMs9sUS71qZ8WcvuUneEGn3Q04ITX5m19HB0SbO6Sl%2BBpV9WLhfh10omfF1ib6byXKrjciCuHwDp5yIWrw9FsAds2ImKV8zjdPc47VajY%2Bxy1bTKLGmxRBahhr83zeOxmaP12HJC0PDGvtZzOMSfrNb2s%2BzQ%3D" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__PREVIOUSPAGE=ZLR5YJNgG_28z3wT_GJVe5VIuhNO4AuAkO5rVgyrhVAbfEkZAmZsfgGhmkjyFFgJp_-2Gi9syvmlGt14SlVDfS6S4XQ4ds_n1K_mI_0jsbSSOGHC0" +
				"&ctl00%24MainContent%24TeamNamesDropDownList=AC%20Milan" +
				"&__ASYNCPOST=true" +
				"&ctl00%24MainContent%24CheckGamesButton=Check%20Games";
		byte[] requestContentBinary0034 = requestContent0034.getBytes("UTF-8");
		String requestHeader0034 = "POST " + requestFile0034 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"X-MicrosoftAjax: Delta=true\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=utf-8\r\n" + 
				"Content-Length: " + requestContentBinary0034.length + "\r\n" + 		// Content-Length: 2405
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0034, requestHost0034, requestPort0034, requestHeader0034, requestContentBinary0034, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0034 = null;		// support garbage collector to reduce memory
		requestContent0034 = null;		// support garbage collector to reduce memory
		requestContentBinary0034 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 5147
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, "|83|updatePanel|MainContent_UpdatePanel2|");		// Test [34] <- Index 34
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [35] <- WEB ADMIN Index 38 ---
		proxyDataRecordId =1564998907771L;
		String requestProt0035 = "http";
		String requestHost0035 = "cldemo.apicasystem.com";
		int    requestPort0035 = 80;
		String requestFile0035 = "/Images/gr_button.gif";
		String requestHeader0035 = "GET " + requestFile0035 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0035, requestHost0035, requestPort0035, requestHeader0035, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0035 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 1179
		// content test algorithm: check size +/- 5%, defined content size = 1179
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 1179, 5);		// Test [35] <- Index 35
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [36] <- WEB ADMIN Index 41 ---
		proxyDataRecordId =1564998909052L;
		String requestProt0036 = "http";
		String requestHost0036 = "cldemo.apicasystem.com";
		int    requestPort0036 = 80;
		String requestFile0036 = "/AllTickets.aspx";
		String requestContent0036 = 
				"ctl00%24ScriptManager1=ctl00%24MainContent%24UpdatePanel1%7Cctl00%24MainContent%24GamesGridView" +
				"&__PREVIOUSPAGE=ZLR5YJNgG_28z3wT_GJVe5VIuhNO4AuAkO5rVgyrhVAbfEkZAmZsfgGhmkjyFFgJp_-2Gi9syvmlGt14SlVDfS6S4XQ4ds_n1K_mI_0jsbSSOGHC0" +
				"&ctl00%24MainContent%24TeamNamesDropDownList=AC%20Milan" +
				"&__EVENTTARGET=ctl00%24MainContent%24GamesGridView" +
				"&__EVENTARGUMENT=Select%240" +
				"&__VIEWSTATE=C9SmPKf85SHdPrAjOdj90TCBxddccATrnVKpMrc%2FNahMUgC4AAeKQk%2FeU29rDxRBChlbzttYrrHWFrDzZ%2BuPlOarbLKhzSG7ik1tw0ir1H1Gq4WY74mP1fRiEuwjrUVHqMiqgvm6xcnTdXgWghjoTQohNr%2Fq%2BLxUGYUvBqXov7qM%2BlEWbIJeL9f6QdCED4o3DECE0ltHwhlYK3yofwvbWp%2BzQz5ccoI55BEDh4tGU9F4nsFQpbYNJeu6xWr7EvYFx6nj9m87MNsZZ%2BSHZcJbuht99vxs8yriT%2B3auR%2FcLHWa%2BP5nDaJq%2FXAY7wmJvvbP0h6WRIGDboM3H8R%2F79KD5zjGs3pRWbNn8%2BYKnP3h37hkwj7CCWXpHcmuR9dKW7Hpe4SMabWL3jCw7wleIJwAjnxVGbYRUpvkThj5M9wn0RS2aBnnSjwZZyVOx5X7lrdoeLQb%2FANeihvHKm19W3xqN5s0ElWbQ85KmAcEMJB9ezrbypCH1RLXVlQ6tmjDshrf42Fjxli%2BBQQFhK6Gyp7psAv%2FAZh87IIC%2Bo%2F3%2B7%2Fg2uAMgG6Zou%2B3sRNEf48scp7NzvC8mJDvW0mcYAyO6cM4YdBHoCn8Qz9eOnhrDWNsC%2Bo%2FUc1gLy8Uv5buGmwZ7vxOTRTLqJTs5a2EvKDlfAyoe4Ly6FrYpkK5Z%2FpS2X2gY0QAhe%2F6ispK5Nid3WSUu9tYYbRhGZbNigjHRF7RibotYZdxT5at4Rho6OqUyMsXR1HXjscbLL2qVHWEcYiOPedhqc2yRuIJB8mCwdASoC1vPr7SknRXfoXx54Iw4hiKAhdIptq%2Frx3PUEkbqj2wCzSSuIvQJVfbnlyUU4pXhW9cb6GJ2M%2BQ4Zkr40iG6s%2B62mnImWwwO9RCAoO7JKqmXJ4IqNg3aWm27sBZtEsrWC2a2EWFsqGY%2F6roXqPsaP%2FyZrpXgr2941zjf4FN8Fi74iEeYd9ma4yNXRK9c4IZw97nT2svGuzfVIlKFSzy9BFfQclzVqr4CvRmkaUGOQ9Zmeob1mXFFv8SzecOf4NtWjOKQQR8O1o17fQv0jeArhT9pJ79jZWZrxbcPH%2BWif%2BZI9JQGavf%2FUoGQjY90x148JKFjAtvLivkSjJ2f6TXskbWtGIvvtCtI9i8T4fJeufDuiZ%2Bp6882m5BQ%2FR9VsHxsT%2BHyVUEny8nQ3bzc09ldsJ3ODMiT%2BQ39uerX5vYdsihN2cStcEqISER44zIQ1NHh0msw5cDbLH6Zx7QHR6KrbzJjNTB54Gqn48cYoCkAkOhHK75tVknJnuClYHY2Ovp7GiZx6sVsvj95tOYlDqwXYOgrxvUKdHj8%2BXDXHpGVeuB1D4NBAs4Q3HWE6wYCSEICmLOiYy5EdHq3qUG0RU88GvO1fBJ1H9G3R0IPnIM50e0UBmtRIAMQMOgzkhzaU%2Bb4VgFvjwLrRwBUFKRx78i%2B3wVPdZqx2I5tYEUEIMKFmjuln0TQeOzZn%2F%2FWrpsu98h6grZ1qgvxZdQqtjkDFgynTlvHQPwA50y%2B6mOOFJol72O9XEU%2FG53ed06452wbhyKzkbHR2I5cMwG0T%2FE5KoBvjX9MhNWPXJ3v4i7y0ofoU795bMOFPmfsroiOHODupUcnJnscZXXNF9CxjvJASD1hQsPicli4nwY00b34YlFq0jNZ2%2FBjHSPw3khb19MvYxo4b5K7KKfYeCIrtCxbjcXEp9suX5V19eP%2FwVn1qW8AfBpQ6gt%2F4e6KeE7N1sa9i9PnFs5yoGOfbit4r9fANRSOI5UnD8AFYam9S1HdRBdXCLRAIsjjQhXpHwtCtFD1JCSdxqosrZTMoezMpcVOI0IW8Rp5uRoR3y28trd9%2BYQnLhrOxY%2F3fZhSr7cJxql9aLTFZZ%2F8TXoDeBMHs%2Fa%2BtbDMQWVxX5qtp1T3D%2FpSrv79aGaIpnplOn8xi2s1q82SrHZPtI96orNQ%2F1ZBFOAOtVheTpH31cYZoZgsri4PGSbPH3clfaxnvVyEH2CpMQqeJcoyIXzgddIDbQWL7TwVDpobUl2bLQyIzU0N7SBZ%2FTeG4yCkBzGa0TMK5dOzKA4GMHbR7yKRVC9US6TG3MqNCWRFSBj9rQQcRhlVtZOUExRZR32KxX5uEpDeWjFpAUms9xu%2Bt8v%2FG0OY1fevCU5LrMAH48rJ%2BSLVawvMBhFt8Y16kPPovPN6%2FVZo6LVXSIFADpansH7KuYjCSH6sMAHR%2BsS%2BFQSQO0zZGqNQVt2x90x2zeT5y7lao%2FjkUpabDXGfsGuijKr8UBF4x0KugOXTfQH5Dr4FSDgMspws85HSF463bg1jhmFumMYtO78dHhvYTP3c644uOMrIbaEUL4FF4Yu1z81YIpI%2FbZdNhJM71o%2BJ7RkDkMjdGMZHPrX%2F1XLqW7JISqIhA8bQsKsE4%2FKAoD1aSA0C3bWcIS2J1icrmEI41TwrnPXmhBiRr8h3ugzj5lrmZwIa9Uvo6ebD%2BCqOVdAIK9U7GobxQAwysD4BYCkZxrqx8LMKwzUjDYOqcm72fHliBEYC191sW0al3h1P7D031VMvU1NErkZwVJfkJCgT%2FeDPZ9XS9cQz3sJl6JN74yMw0JkJNBVm7gb0jCbaw081CcBq2kV%2BV6AmXHxIELLpqhphZEb3g8L03QzhtRuXOOvfEJFFenwRbwtYJxzUxk8uF7EGCrvN49xHrD%2Fo8343PmFMjDW5wEd47Qluf9xSWPQ2HN22jXLV9DNd89J0m5KYh3ZgtmKzJpdAef9Es%2FQ7PtWI12rx0KRgKGdJtexkZCA4M%2Fa86C5HK2ZMe0dXgMtPYQ2DS2g63u5mCR%2FemF5wRe8HVRkIPy3dn035DNUZhpTeCEavTKVZd1IzYc0mgFN2XyyUJ6LnpqjasVwTK2WmAG6PJc5am2OjZH0E0NC8p4iDliCVrCam1FcasssRPZnnpKe%2FT7YtQaQsbjnQ1Ir9B0rSUUvEydLNEU8%2BuKx4c8nD%2BCKp5laVg%2B8047BVZ%2BONjRtxxWed8GTj%2F0VjSIl7WtQ3%2BBIRGCDYVjA%2BEkla7EybNmhI%2Br%2BgwukYDLFnpxDka0tqxNIBTMDrEfmNmuX3UNv1KRDL%2F9lGoQbSArpDm9TJSBpfk4of6GGxTE7%2Fexhj84Eubnz9dO25xWhL9t76sA%2FRAZ%2F79qMnR4%2F6kBFI5zHBc4sCW6wL6ZiJ%2BzK4rP2MxXPqS4MW0TP%2Ft%2FHXwStvFsV56d285hgeIeAJzhN1tpBAEvCu4o058pAeN1XnqOquX9bSjIloK4i%2F8LaZmzF7xYBqbgq9Jjc7QKobQyXH29mdGGdNJLZzc3QnLkmhwlnR0ajNfhGwt9wXnZpLqvChpHaD81ornOv8zpEeU3vaohs%2FPh2TX4MlSVtxM2WlGaIge2hGV4XGiw6Ho9kJXcw96BR1O%2Frlf6%2BihO42lv92qIjUXNekrTyEZtqRklSdD0qNYSgBuzDOnPIMg02HyZFRRE7GQEwmjy1qp2MB5pavdMkjk7eOHgieq2VSsytXAEMCzG9TktpyhaD5Gf%2BPe4fHVf3Xul6PNOGlK910JXE3i3z%2BY7c4LOgOPllJCfWRbiXjvYl6dqMSJ4GiwJ2LNDkB6aAZdsuDmsElhoMsY94Yuja2UI6Vpef8B5DEp2yzEfXKP2zkI81pIX9KVj6uGtIAgpS08TNtmMHNA%3D%3D" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__ASYNCPOST=true";
		byte[] requestContentBinary0036 = requestContent0036.getBytes("UTF-8");
		String requestHeader0036 = "POST " + requestFile0036 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"X-MicrosoftAjax: Delta=true\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=utf-8\r\n" + 
				"Content-Length: " + requestContentBinary0036.length + "\r\n" + 		// Content-Length: 4267
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0036, requestHost0036, requestPort0036, requestHeader0036, requestContentBinary0036, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0036 = null;		// support garbage collector to reduce memory
		requestContent0036 = null;		// support garbage collector to reduce memory
		requestContentBinary0036 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 6173
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, "span id=\"MainContent_SecondaryAvailabilityLabel\"");		// Test [36] <- Index 36
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [37] <- WEB ADMIN Index 42 ---
		proxyDataRecordId =1564998915385L;
		String requestProt0037 = "http";
		String requestHost0037 = "cldemo.apicasystem.com";
		int    requestPort0037 = 80;
		String requestFile0037 = "/AllTickets.aspx";
		String requestContent0037 = 
				"ctl00%24ScriptManager1=ctl00%24MainContent%24UpdatePanel2%7Cctl00%24MainContent%24AddToCartButton" +
				"&__PREVIOUSPAGE=ZLR5YJNgG_28z3wT_GJVe5VIuhNO4AuAkO5rVgyrhVAbfEkZAmZsfgGhmkjyFFgJp_-2Gi9syvmlGt14SlVDfS6S4XQ4ds_n1K_mI_0jsbSSOGHC0" +
				"&ctl00%24MainContent%24TeamNamesDropDownList=AC%20Milan" +
				"&ctl00%24MainContent%24WipAmountTextBox=1" +
				"&ctl00%24MainContent%24PrimaryAmountTextBox=2" +
				"&ctl00%24MainContent%24SecondaryAmountTextBox=3" +
				"&__EVENTTARGET=" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=Oqq83jws2yYrrW9S2dbzKqNRxmh32Gynrg3pi0yjShQpLijR04drsgQLpao2gsCbR95lyG1tdJP9m7MjX31%2BSCN4FthRngProT8tAGU%2FC%2BdbLATEpZi1RIFAudOycq7S6WQsNKJovS22FJ8skD%2FH8hRSLB21w5XnVgw0jPzItryNOMNuCD4%2BXFobTmUSp%2BsMUstqaEComoJOPfzvp8HoPz8rFUpPnBokE6xw5ycA77a8I3WESNvZl9iqVSlmBpMpfj9lC670QAHyYrGqD%2FGKHbdu9fEor7d6pjgaqGJTteyIK9N6MRjJ5sHQv6h6d5hUnVCNeVV0zLBlN1k%2Bp3zg5QD0NK%2BQsn%2BskyIJ%2FBln5D%2Ffna1Q7lq6vRiGutKj7RSKhR%2BUD9ldAQolY10GW58D3YohwH9RaNL0%2BBJP7%2B%2FD1amkrw9iK9WSIoR2%2Fi20ZSHY3DQhn9sdpGFsF3WN32M%2B2qjVv8ebpL5AgELU2Fm2xwWlvkPTKbzminJv20sMo8dLP8kSR0MD3w%2B9T%2BbPSvHyAhISEJ%2BXUTnN%2BGWX7H37cZfu5g74kwYVhm%2FUKcDgN2bpT0wX52MY9Wf4L8OLQk8HvOv0QrS5l%2FEsJPwe9ZEXJXiENNapYEtvw50A4i3l3%2FM6ISC21wqIgosVQBspmWlnEXqwauNhjEoQTHB9s9ZXZUsSBUzjIE4b7wET%2FYMihnwpw1Yu1v6FCPrFnl07K%2FKAimqw4g575qjwCaT3scbWN8zZonw9wC8%2FiqGIk6lR7LSuP1j589K%2BKloaHLiBHDxscZUqe5fJ7p6yfEtZ2vjy4oLb7sGHVhO9RNhU9wEYG%2FoSJIcAYf7UJkjhiF3u5w%2FUdRYyEcKpIwUy9XgsgAOBnGY208DACVAJJelvqpdWpgLx4JcLOAfES4T2r%2FjFS3TFa3NStc1LB5siJ3FcmoZvC1def7kXbJZENpc6FMZYR163dq%2FMQ0m%2FETYze4j1yfEs43NsB7nfSHge4KbBlfTWu7KREiYqJs8NkJZvnFlQu4KIOEOwEkXaxkLokFE%2FG4saMv68cbZSxCpGOfJR9SUcwuCYgWJW3kmmCWzQ8op7haFgpU39V5ow68SwrQnl8mctrW97n%2FiVddeFZ%2BX1X0TXInW7OfC%2B2WybceCTofYX7KN%2F8vRQQgIUQjQsnUXpHXJVEeNMUSjd%2Bc4L5Qenpow1rEW7jHiOr2Z2%2FBSM6mATbl9%2F%2BqeKu8qpfHJUSD%2BrciII6EbSogM7du70WbtbhiPpaRz0oOHTItfLnbVhhSJK8%2BKasW%2BmoJAq4nzifXrmaakOJFnBzAK2RTfuiU%2BnqgIdh0GwdmzKSPrUvSzNxpYHImWZ63EWh9DCCkjm6Lb94BCyjqMKD1u6UU%2BU79XNFZ3hcRsnfV%2FCA2Fj9gMlzWo11xISnJRGba3CFymyYqs%2BdhNyLwmKZ0%2FG10k7L2tgfkIvM2mOMcqOr3AI2I%2FAaxhbL6l0lpDcpt3aNnCk5Qs0ATzQIChCuad1%2Fzahk3ej%2BO1JsDYwmZQHC3LqzJDxNBi8Xbknqohzcwmk4Q0nGRlnF4guio3op5KFjTaBv4RzLekxNJL1tABQdqMrp2srnKIPDoDZXy9tDTHXjZAWrFf5b%2FzYnAX9vn09fhBef0nkytVpnkLWACjpSk%2B%2Fyf8vi1b%2BCEsdWXDVBTBSuIBz6bKAh0cnYW7HgSPMZj3XvkOFWM7sqEieksPqU7SwA8u9JaL%2B2NzdbrnRjEQD4KLn%2BgxcoFyrdyhcuQWJvsYyhWkQMiffLUfPO3IkMJozMLMXniZl5ZZ6jrwebVGiwXtM9YJu%2BDZ8PwFD1dQilJuqCSRPTjoJgBsNtB0ccXx8O7EQRmZGLGo%2ByYo%2B5Ml6mjOkalZw0%2BMcjJ1egUNHsGOzuJSzQAqdAhLPTQI4fOqm3pp6W3%2BgCXF%2BOy5tjwteI8OZtinKrUzcAt6l96FAl9ZCloVKd%2Be%2FOWmPg35Fz7mTryKoKU4VYB%2BGdp%2Frgtlm3DXk77OSs0JH02yied59HsF95Fey3JWru0GDiowHcw2mRGy%2F1w5%2FWQnMarbucvdeQvZ3bd1KetsHhdPVQ6DnQ%2BuIN9HXDq142EC5Jb9quxK0kFc5AtUJCvCcbH26%2BwF%2Bvr0%2BKt055BtDYH7QP43tfA%2BVsmA2y%2FsVpnJnK7g08KaqqX5mfvDWn3AP7Kyw6k2cFYn3ZYvVaKudT2jBQCqdhcAqGJ%2B4uetq6mbveJAdHyCR79rkCuMqk4F61xXvL8npiyVD4qL6E4ecM8%2BlwdryCXt6Jo8lKe43VGtnF8VUrDgiA9Xf4UQccHZVQ%2BMBdrPMuBv%2FpYn%2FjAAJVPaNc8THAvHNUalweW%2Bix6XdWXjAc%2BjHoBcntsOjhgbtYLpofFvHQRIdNToST%2BK2CGSwr8om4lje6d%2BRneUTEdg9Mj0U1AfxpfudXQzed2jqtab0NmbUIAf1YPOZ2aMydq7OUXhlz1sqzmGINhOxV7CrXtIPQoUec31j4ePObmjwnEBMtdJkVhJA%2FvkOFGFdVUemUoALhMbtIr5mrutpZSt%2FWDkKlf%2Bu37vtdC6qP3qQooY6vxhSckVYMhvP6N7HRMlq9J2bmpQaOFPtnCtvsFA4SUp9U8DDCI%2BTtMP5Kojni4mEh8Up0s6f0T0PcNmzutUWkDfCzW5dVkYBDDJi1ZiYtE2IGGwLV6XpH3XAzbeykbtB1FJXEuI63BVJ5M6mQ4NztzkP5pC2yJ%2FG3RYdGBGqa8E4nVC0MTQoR0yK5L0f4ODFvzZoL%2FzqOGWo7T9gKs1tb3vmM378IIaBZgpTi%2Bu4BiLtUGwnLVGrdPW3PLS7AqeigslfwSJt%2BAUv1u1AOfFS0uAFh2qFLxDm3jDlVPnjERIBN0TZ7%2B%2FGUoj6xn3KorikpD5JAQ7WPm5JOMG7jEP6ruZ5VrRyZwl2LwhUVhu679w7xG9%2BCfvEErwHHhsbQvIp0epPh9dmQsoMe4hOdCr2YgF425ss4tE70aeS8iIRAePsy8w1cSkFvDShg6FwC%2FpVoVYJuB%2Futpf3n1jJpi3RRekcBJDp8Qiouh9bjULq2iyg%2FCBzXZsCThQdhWwBpMwuyIg1TG%2BdLdYD8Ylmg%2BbUWfVNUv%2FNSCxq9%2BPZ26197L3VuJK15zaXXnW36%2FjtK811PxR9Sb1GgBrbWGJ2SWN6FyRp3MQUaTPtc0dbYC7DsBVx1FrCSw5EJDrAlxWcb4ouqy%2BX0ensDUQB9C6CWScMPRzgqrdd%2BK1GimOOafrXMj3C9rMZwdQ2yDL7P%2FRLYB1v6scGFOKNbGNgleaKaXotMXigBpl%2FEf0lJI84BRXeSR4ztf%2FzNANxYLWi89WVCiVT3w0%2Fn1%2B4xEdPr06pNmqKJBuRteJsRmxea47%2B3pAMCoywXmGmQMvKJ3y06Kjlpa8Fp8Ype74Wv94pR8btJfmKi4Ke445sytj1Qm%2FYKy6m3ayz9L8RJJnYhgLWYgHGDWR%2Fzy7x7x09ZEdtSLe6rFPR3DZ%2BTdt9Uscu3wEDVQbvJPQmhpRLpG3sj33HCdNC45SLTm0mk%2FEyo8ckK2FJYlsEJYteS553uiB%2Fgy38PHLIRJzrLSzWAIDz4O0t6exuEgm757qHsNUC0Xy%2FFFZNx2qeF5Ywon%2FWpZes1JbRSLSCTBRb0aHif7i1CjZcArinRZV89%2FRRShFrLOlIFfysvRwHH%2F8m7P8QbN2B1FwDQvYjV53725sJ1pJK2PvOwzsgQ0yLxFQgSird2Owh4ackHAOrXK92V4CtOOFwpvhq57acnF8P2oBgCFBa5pvUXcDJg29TxDHIckMXFi1KC9NO0Kb5mHe9fwiBngIGLHULBWHck11jVO9ZFXIFVaRQA02Dw5sYYU3UtXsxWDyUm7dperZCi7wouq9HeHpA4NpqQq1%2Byz0NRMTaS8FRr%2FGZopg%2FaC2heA%3D%3D" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__ASYNCPOST=true" +
				"&ctl00%24MainContent%24AddToCartButton=Add%20to%20shopping%20cart";
		byte[] requestContentBinary0037 = requestContent0037.getBytes("UTF-8");
		String requestHeader0037 = "POST " + requestFile0037 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"X-MicrosoftAjax: Delta=true\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=utf-8\r\n" + 
				"Content-Length: " + requestContentBinary0037.length + "\r\n" + 		// Content-Length: 4731
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0037, requestHost0037, requestPort0037, requestHeader0037, requestContentBinary0037, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0037 = null;		// support garbage collector to reduce memory
		requestContent0037 = null;		// support garbage collector to reduce memory
		requestContentBinary0037 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 5844
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, "span id=\"MainContent_SecondaryAvailabilityLabel\"");		// Test [37] <- Index 37
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [38] <- WEB ADMIN Index 43 ---
		proxyDataRecordId =1564998918949L;
		log();
		log("# title: View my shopping cart");
		String requestProt0038 = "http";
		String requestHost0038 = "cldemo.apicasystem.com";
		int    requestPort0038 = 80;
		String requestFile0038 = "/Checkout/MyShoppingCart.aspx";
		String requestHeader0038 = "GET " + requestFile0038 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0038, requestHost0038, requestPort0038, requestHeader0038, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0038 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 5424
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "span id=\"MainContent_ShoppingCartLabel\"");		// Test [38] <- Index 38
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'vEVENTVALIDATION'
			vEVENTVALIDATION = htmlContentParser.getFormTable().getForm(0).getFormItemValue("__EVENTVALIDATION");		// recorded value = GhBiBDEpZR3IlzI2XTXk4TCe5MKlvOnA4uXqdZA6Zx9KJZ4Qslz2E6+7Ix7cN+fiP6iIubNSKoIOLfOEgl0oGWEnWWcKAZ3q00vQiidB0Dfz0BB/z5lnY2ZmPkrUa9SYrrdMyD0pA6WKHEH3hw78Njr87hIDv0mwW1GEnz62AF1rzOnbpV+Xr07uSioIZZ0lM4IsyOvzdaQ3nMwY14Lacp6GFcI=
			log("<<< vEVENTVALIDATION = " + vEVENTVALIDATION);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && vEVENTVALIDATION!= null && vEVENTVALIDATION.trim().length() == 0)
			{
				vEVENTVALIDATION = "";
				log("runtime note: the extraction of a new value for the variable 'vEVENTVALIDATION' ends up with an empty string - a substitute value was set");
				log("<<< vEVENTVALIDATION = " + vEVENTVALIDATION);
			}
		}
		catch (Exception e) { vEVENTVALIDATION = null; log(e); }
		if (vEVENTVALIDATION == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vEVENTVALIDATION' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vVIEWSTATE_1'
			vVIEWSTATE_1 = htmlContentParser.getFormTable().getForm(0).getFormItemValue("__VIEWSTATE");		// recorded value = rtjYoSYTG2AdPQK32niOW1aWEKv/yF0XDY5BDRsbL5y+5ySzRqqqW0t9SDekgS/ejurulhJ0YdCuyF/nIGXr4kKXp1JZlEytQ2CK2oQi8DybRvZ/fCLqY00CKaRWWDxTRxheNikLdIrw/R7goJmycZDP3H1vTBs4iLOxgl9/lN7E8DNyDH4A5MLrenrTwXRzrhWYvWX+4J2AKCgExHRsvEpqQgxjPfRXjQHgHn/Zn8K64HqVKx0gBZM5wztpEvLC3xqvgQXacMB/lvfhtzVK54QIEr0P2ZHy3o4uIqWNZGUjd2fSC9s3WxK7xyPwNl9iT1RkZXoFlDDDvNA6K+OtxJOhM77Y023fmXUVYCWF4NMHTy5ZKxZFMvQBwKt+3ksnf8PksWDZApHq3JpfmtGZHRsnWtnPGavc++Up/iGskKysdkj3nD3VsArgicNuAkewYzKGD70H+BCPjhMzjHDdADVj0yLClxVBKeBYTMMdIkQBKx34dpkW7jubd9CbNHF7Ey/3kFkV9yJrwcZgIFn5A7AVEL1Pl5sDQrp0wcxvy6TjFQ1t1d9uKCJQYvC7+KOYozzZ4iAu60Lr725QDnYGZrCerQYHwhBs5afzdtdAChf3XGNdzHSEf2/0Ydzay9MvsBo7cDll8g9G8loRpbm1vDH3fQ/D2SdharwcorG9lZEXQaq+718LBgmo1QZJ1cUZsWz6YJXo1d6uB7yAax+I7X0GQsZAXhGjAdxKl/fWW//3yBRxFPt9pt6ZCAr9Ua6LbaUP9q0/fWIMwOh/x3chxrWQuK9A98X8TBIiJl56lSz4kMOEe7bK3mRggV8+t08xrMnR9xyHAPuF0YPAhe/SldHu49cIqieAiggwbLbcne79XYpUiS/p9q1dfyAVvAm6V+UdkN/37T5lKISHMXXF15UBll98vz/pRq3EDRbmvIKH1Gk37fRDGVaAH7suD8k61e5yC4AVtUybBX87ayPqPl0TJp9PgNKccknI6uzKQli5lJS1Bn0iR1LEPL0rtSvGC/mSAFNeioxgLJrLFqK8g2fL/eu6Gpj2BksM5/kTKrR5InL0uQYCNb/eT96jjRfAyonKk1InHK/R270i9J4Uo3BloTLjZyOm38H4mnLNvIoCmoaurbJMXOM13Pr3LaLo2uLHbXksZWL115o8bcsS86/b29qXZRitV3cnZwKqZ83gOAGEs8AnlTw3gMb1hx7e+QE1wCzKQScyrrxW6RVa1D5xOavZzdo6rgoAZlahYkTPsLF07QZ472/AuQ5992u5tAmpvg==
			log("<<< vVIEWSTATE_1 = " + vVIEWSTATE_1);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && vVIEWSTATE_1!= null && vVIEWSTATE_1.trim().length() == 0)
			{
				vVIEWSTATE_1 = "";
				log("runtime note: the extraction of a new value for the variable 'vVIEWSTATE_1' ends up with an empty string - a substitute value was set");
				log("<<< vVIEWSTATE_1 = " + vVIEWSTATE_1);
			}
		}
		catch (Exception e) { vVIEWSTATE_1 = null; log(e); }
		if (vVIEWSTATE_1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vVIEWSTATE_1' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vPREVIOUSPAGE_1'
			vPREVIOUSPAGE_1 = htmlContentParser.getFormTable().getForm(0).getFormItemValue("__PREVIOUSPAGE");		// recorded value = P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0
			log("<<< vPREVIOUSPAGE_1 = " + vPREVIOUSPAGE_1);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && vPREVIOUSPAGE_1!= null && vPREVIOUSPAGE_1.trim().length() == 0)
			{
				vPREVIOUSPAGE_1 = "";
				log("runtime note: the extraction of a new value for the variable 'vPREVIOUSPAGE_1' ends up with an empty string - a substitute value was set");
				log("<<< vPREVIOUSPAGE_1 = " + vPREVIOUSPAGE_1);
			}
		}
		catch (Exception e) { vPREVIOUSPAGE_1 = null; log(e); }
		if (vPREVIOUSPAGE_1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vPREVIOUSPAGE_1' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [39] <- WEB ADMIN Index 44 ---
		proxyDataRecordId =1564998919039L;
		String requestProt0039 = "http";
		String requestHost0039 = "cldemo.apicasystem.com";
		int    requestPort0039 = 80;
		String requestFile0039 = "/Images/select_item.gif";
		String requestHeader0039 = "GET " + requestFile0039 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0039, requestHost0039, requestPort0039, requestHeader0039, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0039 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 1096
		// content test algorithm: check size +/- 5%, defined content size = 1096
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 1096, 5);		// Test [39] <- Index 39
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [40] <- WEB ADMIN Index 46 ---
		proxyDataRecordId =1564998921091L;
		log();
		log("# title: Pay and check out");
		String requestProt0040 = "http";
		String requestHost0040 = "cldemo.apicasystem.com";
		int    requestPort0040 = 80;
		String requestFile0040 = "/Checkout/PayAndCheckout.aspx";
		String requestContent0040 = 
				"__EVENTTARGET=ctl00%24MainContent%24CheckoutLinkButton" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=" + java.net.URLEncoder.encode(vVIEWSTATE_1) +		// recorded value = rtjYoSYTG2AdPQK32niOW1aWEKv%2FyF0XDY5BDRsbL5y%2B5ySzRqqqW0t9SDekgS%2FejurulhJ0YdCuyF%2FnIGXr4kKXp1JZlEytQ2CK2oQi8DybRvZ%2FfCLqY00CKaRWWDxTRxheNikLdIrw%2FR7goJmycZDP3H1vTBs4iLOxgl9%2FlN7E8DNyDH4A5MLrenrTwXRzrhWYvWX%2B4J2AKCgExHRsvEpqQgxjPfRXjQHgHn%2FZn8K64HqVKx0gBZM5wztpEvLC3xqvgQXacMB%2FlvfhtzVK54QIEr0P2ZHy3o4uIqWNZGUjd2fSC9s3WxK7xyPwNl9iT1RkZXoFlDDDvNA6K%2BOtxJOhM77Y023fmXUVYCWF4NMHTy5ZKxZFMvQBwKt%2B3ksnf8PksWDZApHq3JpfmtGZHRsnWtnPGavc%2B%2BUp%2FiGskKysdkj3nD3VsArgicNuAkewYzKGD70H%2BBCPjhMzjHDdADVj0yLClxVBKeBYTMMdIkQBKx34dpkW7jubd9CbNHF7Ey%2F3kFkV9yJrwcZgIFn5A7AVEL1Pl5sDQrp0wcxvy6TjFQ1t1d9uKCJQYvC7%2BKOYozzZ4iAu60Lr725QDnYGZrCerQYHwhBs5afzdtdAChf3XGNdzHSEf2%2F0Ydzay9MvsBo7cDll8g9G8loRpbm1vDH3fQ%2FD2SdharwcorG9lZEXQaq%2B718LBgmo1QZJ1cUZsWz6YJXo1d6uB7yAax%2BI7X0GQsZAXhGjAdxKl%2FfWW%2F%2F3yBRxFPt9pt6ZCAr9Ua6LbaUP9q0%2FfWIMwOh%2Fx3chxrWQuK9A98X8TBIiJl56lSz4kMOEe7bK3mRggV8%2Bt08xrMnR9xyHAPuF0YPAhe%2FSldHu49cIqieAiggwbLbcne79XYpUiS%2Fp9q1dfyAVvAm6V%2BUdkN%2F37T5lKISHMXXF15UBll98vz%2FpRq3EDRbmvIKH1Gk37fRDGVaAH7suD8k61e5yC4AVtUybBX87ayPqPl0TJp9PgNKccknI6uzKQli5lJS1Bn0iR1LEPL0rtSvGC%2FmSAFNeioxgLJrLFqK8g2fL%2Feu6Gpj2BksM5%2FkTKrR5InL0uQYCNb%2FeT96jjRfAyonKk1InHK%2FR270i9J4Uo3BloTLjZyOm38H4mnLNvIoCmoaurbJMXOM13Pr3LaLo2uLHbXksZWL115o8bcsS86%2Fb29qXZRitV3cnZwKqZ83gOAGEs8AnlTw3gMb1hx7e%2BQE1wCzKQScyrrxW6RVa1D5xOavZzdo6rgoAZlahYkTPsLF07QZ472%2FAuQ5992u5tAmpvg%3D%3D
				"&__VIEWSTATEENCRYPTED=" +
				"&__PREVIOUSPAGE=" + vPREVIOUSPAGE_1 +		// recorded value = P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0
				"&__EVENTVALIDATION=GhBiBDEpZR3IlzI2XTXk4TCe5MKlvOnA4uXqdZA6Zx9KJZ4Qslz2E6%2B7Ix7cN%2BfiP6iIubNSKoIOLfOEgl0oGWEnWWcKAZ3q00vQiidB0Dfz0BB%2Fz5lnY2ZmPkrUa9SYrrdMyD0pA6WKHEH3hw78Njr87hIDv0mwW1GEnz62AF1rzOnbpV%2BXr07uSioIZZ0lM4IsyOvzdaQ3nMwY14Lacp6GFcI%3D";
		byte[] binarySearchPattern0040_0 = Base64Decoder.decodeToBytes("R2hCaUJERXBaUjNJbHpJMlhUWGs0VENlNU1LbHZPbkE0dVhxZFpBNlp4OUtKWjRRc2x6MkU2JTJCN0l4N2NOJTJCZmlQNmlJdWJOU0tvSU9MZk9FZ2wwb0dXRW5XV2NLQVozcTAwdlFpaWRCMERmejBCQiUyRno1bG5ZMlptUGtyVWE5U1lycmRNeUQwcEE2V0tIRUgzaHc3OE5qcjg3aElEdjBtd1cxR0VuejYyQUYxcnpPbmJwViUyQlhyMDd1U2lvSVpaMGxNNElzeU92emRhUTNuTXdZMTRMYWNwNkdGY0klM0Q=");		// note: the search pattern value is base 64 encoded. decoded value = GhBiBDEpZR3IlzI2XTXk4TCe5MKlvOnA4uXqdZA6Zx9KJZ4Qslz2E6%2B7Ix7cN%2BfiP6iIubNSKoIOLfOEgl0oGWEnWWcKAZ3q00vQiidB0Dfz0BB%2Fz5lnY2ZmPkrUa9SYrrdMyD0pA6WKHEH3hw78Njr87hIDv0mwW1GEnz62AF1rzOnbpV%2BXr07uSioIZZ0lM4IsyOvzdaQ3nMwY14Lacp6GFcI%3D
		requestContent0040 = new String(Lib.binaryReplace(requestContent0040.getBytes(), binarySearchPattern0040_0, java.net.URLEncoder.encode(vEVENTVALIDATION).getBytes(), 0));		// search within the request content for a binary pattern and replace it with a variable value
		String requestHeader0040 = "POST " + requestFile0040 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0040.length() + "\r\n" + 		// Content-Length: 1858
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0040, requestHost0040, requestPort0040, requestHeader0040, requestContent0040.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0040 = null;		// support garbage collector to reduce memory
		requestContent0040 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 14823
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Please provide 16 digits with or without dashes");		// Test [40] <- Index 40
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'vVIEWSTATE_2'
			vVIEWSTATE_2 = htmlContentParser.getFormTable().getForm(0).getFormItemValue("__VIEWSTATE");		// recorded value = /wEPDwULLTE1OTMxMDgyMzAPZBYCZg9kFgICAw9kFgYCDQ9kFgJmD2QWAgIBDxYCHgRUZXh0BQk2IHRpY2tldHNkAhQPZBYCAgEPZBYCAgEPZBYCAgEPZBYEZg9kFgJmDw8WAh8ABQE2ZGQCAQ9kFgJmDw8WAh8ABQQ0MDAwZGQCGQ8WAh4LXyFJdGVtQ291bnQCARYCZg9kFgICAQ8WAh4Dc3JjBRh+L0ltYWdlcy9Mb2dvcy9henVyZS5wbmdkZK7X42PpYXwkl7XIbl4wl5C06baI
			log("<<< vVIEWSTATE_2 = " + vVIEWSTATE_2);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && vVIEWSTATE_2!= null && vVIEWSTATE_2.trim().length() == 0)
			{
				vVIEWSTATE_2 = "";
				log("runtime note: the extraction of a new value for the variable 'vVIEWSTATE_2' ends up with an empty string - a substitute value was set");
				log("<<< vVIEWSTATE_2 = " + vVIEWSTATE_2);
			}
		}
		catch (Exception e) { vVIEWSTATE_2 = null; log(e); }
		if (vVIEWSTATE_2 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vVIEWSTATE_2' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vEVENTVALIDATION_1'
			vEVENTVALIDATION_1 = htmlContentParser.getFormTable().getForm(0).getFormItemValue("__EVENTVALIDATION");		// recorded value = /wEdAPsB78glrgNv+Bp9WNw1CfNelV27k2ajaruFLYNWQx+HeFEqkvdsY5v6fLjty194vGALawGdIoTjiIP/mjgfIrjPlV5Sb0ZChIHd9vGj1hUh9M3/gsEAZuvsLqaPpX0pvQML21va6msjUtv5NBLKYe6+TaJ1rv5LEWnAXC+PmtfuXCti7f2+S7SHP2lzGb4vmbrKOCvh07sBdB61tBsSK4yj+AyrKeKT/oXfjFf+hhsuu4uFT37wxzasB84iHCmiEpyZXRKJ/DwFN7kEwhWY3OtiJ6lqisFRkeX20lx6Gj+U2qGl3F/Lwkaiu1cRQp5EeSILjDRtyBlReffBp62AZYAw0NH83NukK7iHnZGsAvhnZcKYYxLAcqSZORcDiM++VvyhihIdBkP1EztC20ruX17qf5jfM8UJ28BMMxm65K+KUhmKbniTWKs800KspMJCvB6zQn2RlQD+G/iKPNo6P4wlQEFr0Ra3Prs0Ad8XFN9jqJ7bTfQWqjsJjVB/h7/mNYzFbg+66eT9892HQisI7w/YHdITx8/EVstLnNM+jL5laSKku4n6ap5A39csaW1i61dT0SqQExWxGmMmcGkadyMBJ0RO5c1n8wD4L8T/CUiAVNKhmW1n25fGtes6ak1WLANCsVyReWdqZsISC8BuyPxSNRBSRgBFWHYOBc+jeq79L9IVsBJSqAAmekQ5tzZG2ahJyv/pUDKGBMd5PGZZIFFysNsy1YISWFDEOMNEO6CFa3bUCLmChYsbslMeMbYgyW3/rSvG2pOBx/N/3C50QEZURvybVjlyh9eYEzAkb14ZpJM2eIc3gao0dnKuZp4HLwxvzwgF/NMLLStVEJy5dBTyJ0taaX1XUftEfQycovHyT0HWrGADC8s+8XrlZX3Qu1vBoITfUkXQLYgB5rE5qT5uSfvglNZeepFIagXSq86NfD0glZxEj58Vs4UCC0q4pRXb6lv2epqa6So8EHmdSxtx+in452T8EkbBkUnoOCGQdH91gVfIPdpGll9BpBj5A5SDt14ItYQOe778bVlrp5jrXezwz4kK8+eVOnGExuaY0N3R1xAUYc1zzJDC4qLDx7nyTBejS+tnxs+xKJ7Riq5D9p6Qx/keetqSABwLmhZ4gG0FC5h+vFi2+MT90ONtRJy9RLK8Lx4z0AXyU+NwW5K9yEqPXcKXv0Gtw2EHXttkuSkj6pvHsY0D8DMWikicjKr6pB2QB8ZSwFwNvyitijkisMb/WxSSruKYA74Jf7dsGSuPDpjRy7+D+zvyQia7cs0BPPnqyNy1MB/jwjyidXXG+WcEkVyRfjnUjVMJqyMIS0VoecFbQrylwvUcuQ/zSCxrl+JEsEjJ+r62yPM7Xhm/cwyA0OZBRtznHpGMg4WgcTrhHBWJwD3F/nSmHUatvmyRv/LL4MJJr5ZA47340kXH4WgNRLA2JG9CRdXW0jgtmQ/wEncP65uDMQJ1TU9XaiQ3osXpCYzh3PcJNCvmNqb/0SgcNvPvHsRdQRPUSCU33Ld34YqQfxSmWz7Q7+ajpKoNViE2aanpCQG6/DXjQBnvcwOBsGw+7wumXbImX5+V22re/5QlxBHBJrjIJpUi+sVlEX5kVReXovDxk0szLcV41TPynqtV3Fg585uP42zQBxv3ZVQR2U8sPw+5otyF9Uzz7OEsf/m99vwPaPA3w6cjLS5ap1kebN0yhsfaHyPtFalhJy+TB+AP5CuhUaXY0oEwhZ9xQsSm5HCIqaxQtUXtGvXH1E7LbQ+fDbJP/36JlC832rcsKFo8Nl3e3+aEvyY3APfCFovvDfa2Y+2BYDVQ6HsTEy9fo6fbCGaQER6Fqu6VnY2G6u7H2gb/nGoIIk/HUDX47D8oeV3oJC9YOQqjHHxDGi3WpGUpXwa01EHeEBud83zfVq8Xc8zgTZPvsAPgyktVR+sW+isPGo51t/UYYhrodJ8XjlSJHp2zM1AmwYPeQLcBw1gSpBvYRlvpt94HcgA6XRVaJkCmdxsGRF6EQKDHNz7GoUTXt+r8OQOCDScFHz14DNR2MZPNo9vjGslh1d7A9/nxkSb3+syI3h0lzN2nbqaecfyKOqC3qOqxFkAwUnFZVlEfzaHMqqAjdQskKculpwBHvktJbAlz2crROwSkfV3UcHBkMQcjaK72EwkzRMjGCBgA0G2iJf5GmccFBQ4Ll9WSqsq7clmJgEABPdwrfyhRcF+PBTomHsD6ocQj3EX3aoaC2BPRnlvuw1dzaGCnqAc6Du+6Thn09zMF5z/wDX6Mrc/mBu9ONrswrsJurXlQjzTOnLY37/OPd8LN6J5kLtetQEKOoF1IkN/GHPxXaw3YwOaQMHBPme/NNB4vRxXK/x6IY4AoTdaOGm2G1EXyqM4bWWs4tabIa9ZfhSoJOlbWKGl2VgdqH07NgeyuQpRxTURPcxHwTgKcjDJl2QkBizI76S/yeOqSIs0TdhrcHE5Jirqwo492F4LoAM5HHeym9c2dzjcCVm37p7ByzyytPcUeWmTm860YZZf82oFxBX2Eygg8JTl8TEiy5zML8q6L932wFHRZIgzRavNBHRX5VPJk+ct72nY6Kb+J4hLFDmCHfP9uyy728aUbDCwqwXlf37OyeS0uEDEL7faMuOKgwSSOpx8FxXIuS3WvQD7zDF6CAtVMykapVDoxsBS8snofaIj4agGLVrAdU6nsiEr3FF0gQJK+F26SWBGglljkmoomet2TPpbbZQw1ZkrnyzL5qw+5p5weE3WEkGakSh7ck6+noU1FkkMwja7ELFo/3cZ+LhYojAl4leQHCVIUoVRuzuEF+3WOWbrwohl9KSDSaBwrBvpSOAxgYOlhtUFomre4Wq3QrBfuNJjQorhsX5Jz8tugihW3Zc4vuVhtSuJXMNH5xT5QFFq2EE/yBEtbaeTdz+RtQ51hW2YMNlGOBNCBAUkysLZduwhJ3YTwGHu7S+bUj3Slv1XVrpIECBWvh/EjsCR02o8Jk2AhB7MCFjpCD5aDeyq8hPaRb8BOlC7J9YcRP0mkVg09GtjszfuveFN98twCjTHry1IDXBgRGgGCZpJ8Iv2ZGRc/hTJhB76NGOa9HR9gLauIE6ZdLGZr94QGhu+Uby4LEQzgedtjwUXcyTWH5tlfsEcOMrFyOPLDfzB3W0jJ5JMNds2pJF5OFd3TbS7c/147lt1igBzskSZGkGnN7GHTbqm70PhHamo8PPNIcfIT962iyj4nic5Q12xHW7+Kku0C5EdrkhlIhn1c9Ak+o9GhekeOM/1A3J9Znd6j5BMCfAfvZLQNryky4UY09flQVPlxR5asRH/d7zNJfxtaOv1wCoqwrxfSTSS6n1Wxkbxc2xqkZYkPk3yNjTigaloY0qOcUcO8XSEsurkR32UhaQDEitrlRXtIRwjv+ixoFDAxrFDIg4cwUS1q7P1KRtm4Ph/8e4RoP/ZEjPHmsBbQkbpP+jU0HV65dmZ8ubKZRSdDJNzjxYqB0FNNk/dJ5diZrjfJIsPuh4NAhlT+Ci6PcDmt4TrarRwxM6/ocLxPNfRiwXKK6XHapB26AQxd3CYo3HKpJwrSy6iekUCU1pljh7zQMAEFsJrIv3aONqis3a317lxEo0cwC+whVQG+L8aE9kPmD4AGlfrJZCt7YZ/q5J/ArJ5IirewQzLyYAAtLPHqt+Z57roqC0182vvbnonpDsU6O8xomzpJxRPZDvpQhu2+mDhrVnAqwOMKY8I6JMO5+wQBshZjyfqfU6Hw0c9tgp4PoWoNslAvI08mr2M3APWt3sf0Yy2Xzq40vx2K7h4XQAzDCKbNWRCO+RkJRdVPaCnJPmcHtPkl0+qBTTFgshhFowgfjwQXKU8Tn9iNrO3lLkPUbwN3VD2ayX+TCFLsjtowkWnHnKeQhgIEIrGJbB1PCpY7mMSXZhRCeBcKKQ5VKKgLPRTjpSbyPf6dCMIiduKr8t93xQrKHxCbCeeZY/iMsGFjiuh4s3pNSvVuZOVkAy7aGByNsRMUXZ+P0BcvLVfmmHK10HXlu7alfDKIjlYP+jdVhXCrv8ILdRRqwXCfEzONto2UUBCYdYQQUts/Kj48y11asDbZ8NnebvSmqGs6nF4YCBp8Xb5dcAsetyRu+7PYQaOzYv/7i/xELEBOkDAsymU1zmrGMHMqyEd/ueAdd30aoFuVxfR7MnB0vLjJjCBEviy8VuAckM9K6F8ePynuE7J0JKMvhwnf3D2w6EZyncPmwxEcKWkgcLh3Hx2ReDdnobTp77rWPAnSh/UEvc1tyOALbe3W0SFes8X7kfFCGgwRsAu37wAaLxoelv1l8BqV9l5pLEIpARc5eaZihUlyJCR5ALcdJ3m4uUN1DF4bynLKBFSSv/Spo/egAeEDCpPcG+tI1wkTwhGNN/SeQhA9UKPBUo/DifB9OEuSPTmr5rW7UdNFohcF569802/DR3xm714nVDNZzc0up/vn7DPOXZxWM/BqfnZDnDRKawKPYvBNA2JKxvOtYlqUVrrHUbF5f4npOUlgwK7J/b8UQgYkK+1+rZcyEZtjt1FdT/mGti2p/p4H9xLOCFqcjSarh4GtyDLjWxz2v5KS7R87/8syWzaFJwwJdHf2pYOaqVN4MfdhoL340VcHih4SjfxlEZJkVO4Zqnjl3mYAizkYB0YDycbmuSAxT62zq+rNOxo/Gwx3h0+f9DwxkJhXLmG4f3h8V+Vdt7WLTygVgpAVeo6ygS1PdtG65fCBPd8W2k0CSr+36bcrAqbsgNGWJ3ftQjx3LadnhU7Ydyj9ypR5q1ofxfEAfJZMkcs8VH0ftCPMgv9OoLgkndEf8Wb2giA9gjDq05IAuHogbjhBm1U4ILX0kUs1bcSfNY5wZDEkZqULVE15eSNDTmpv4Q7nb6R0+cLCtq0OEk5TctA0XaPpaQsTYh2nl/++sm9GEjWDvnt2/8FPtB5fexD1ML/1le7PJyDmzQuN0WGHK1awmq14KroxeLfq7Jo9W0Ev09Z0GlBFyGrZVXjyn3Pjy4XlWZoVZhwE21mzeaOwbCchj/z7pKnCDTHGL+uJLcVYGPmjIK5HNhhiqzDV0mWMF0tmKOD27/BZeNqnbDLYgQ7GjtUL6BbKRiF/i7yaLW/Yas8qs2Ka5aNt6MaRhGY01CaRrem5xggcuLFTl7HWDNdyauouityFTBgWxid7EpoMvh7CSJ0CVg8+WgMH+wbiWVhTUziNO8fHhOygI3rb9yliYqezr45EI0otr2NHRxEAGR7WxERtfHUqjHKau+QN7l3Ac86tbp4w8klyBcggKU6zhPHotxY3T3a2f9ij/IPXgCHOYsCEAZwa9rOxvhzzYRpWf11X/2Vv3G0UZO/d1Dv61Nm9xfklcqY855WFUQhv8g8TSl+j0nPYBOPe6WNZow==
			log("<<< vEVENTVALIDATION_1 = " + vEVENTVALIDATION_1);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && vEVENTVALIDATION_1!= null && vEVENTVALIDATION_1.trim().length() == 0)
			{
				vEVENTVALIDATION_1 = "";
				log("runtime note: the extraction of a new value for the variable 'vEVENTVALIDATION_1' ends up with an empty string - a substitute value was set");
				log("<<< vEVENTVALIDATION_1 = " + vEVENTVALIDATION_1);
			}
		}
		catch (Exception e) { vEVENTVALIDATION_1 = null; log(e); }
		if (vEVENTVALIDATION_1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vEVENTVALIDATION_1' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vPREVIOUSPAGE_2'
			vPREVIOUSPAGE_2 = htmlContentParser.getFormTable().getForm(0).getFormItemValue("__PREVIOUSPAGE");		// recorded value = X1D7lKVFLKxnD6o_HB8q5Ns9XEjJFfkeGqyX9qfSrRiknf_6dIU2GcQBEZJC2_2s5c4fb8f25Wy4fcw19HArtH0QotjOiPpKlQEmmXaEa9FDBZ8n0
			log("<<< vPREVIOUSPAGE_2 = " + vPREVIOUSPAGE_2);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && vPREVIOUSPAGE_2!= null && vPREVIOUSPAGE_2.trim().length() == 0)
			{
				vPREVIOUSPAGE_2 = "";
				log("runtime note: the extraction of a new value for the variable 'vPREVIOUSPAGE_2' ends up with an empty string - a substitute value was set");
				log("<<< vPREVIOUSPAGE_2 = " + vPREVIOUSPAGE_2);
			}
		}
		catch (Exception e) { vPREVIOUSPAGE_2 = null; log(e); }
		if (vPREVIOUSPAGE_2 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vPREVIOUSPAGE_2' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #1_1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1_2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #1 (fragment 3 of 4)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [41] <- WEB ADMIN Index 47 ---
		proxyDataRecordId =1564998921165L;
		String requestProt0041 = "http";
		String requestHost0041 = "cldemo.apicasystem.com";
		int    requestPort0041 = 80;
		String requestFile0041 = "/ScriptResource.axd" +
				"?d=jOGxQGN59jALlw_Z1PRxPfmS-Xppvs8izQfuNMHYj35_zT6Zd3JCd5GnuBy_KVgc3vcdXbkfuK0SsSvYck6nRpmvO8TXLM9OC4xICzx9PeHHLdOSU5QqsTI9r7E0Th_QhpDzrlKE2Xt8LScmVEPDBF4RJyg1" +
				"&t=362a7238";
		String requestHeader0041 = "GET " + requestFile0041 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0041, requestHost0041, requestPort0041, requestHeader0041, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0041 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5479
		// content test algorithm: check size +/- 5%, defined content size = 5479
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 5479, 5);		// Test [41] <- Index 41
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [42] <- WEB ADMIN Index 49 ---
		proxyDataRecordId =1564998943478L;
		log();
		log("# title: Pay and check out");
		String requestProt0042 = "http";
		String requestHost0042 = "cldemo.apicasystem.com";
		int    requestPort0042 = 80;
		String requestFile0042 = "/Checkout/PayAndCheckout.aspx";
		String requestContent0042 = 
				"__EVENTTARGET=" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=%2FwEPDwULLTE1OTMxMDgyMzAPZBYCZg9kFgICAw9kFgYCDQ9kFgJmD2QWAgIBDxYCHgRUZXh0BQk2IHRpY2tldHNkAhQPZBYCAgEPZBYCAgEPZBYCAgEPZBYEZg9kFgJmDw8WAh8ABQE2ZGQCAQ9kFgJmDw8WAh8ABQQ0MDAwZGQCGQ8WAh4LXyFJdGVtQ291bnQCARYCZg9kFgICAQ8WAh4Dc3JjBRh%2BL0ltYWdlcy9Mb2dvcy9henVyZS5wbmdkZK7X42PpYXwkl7XIbl4wl5C06baI" +
				"&__PREVIOUSPAGE=X1D7lKVFLKxnD6o_HB8q5Ns9XEjJFfkeGqyX9qfSrRiknf_6dIU2GcQBEZJC2_2s5c4fb8f25Wy4fcw19HArtH0QotjOiPpKlQEmmXaEa9FDBZ8n0" +
				"&__EVENTVALIDATION=%2FwEdAPsB78glrgNv%2BBp9WNw1CfNelV27k2ajaruFLYNWQx%2BHeFEqkvdsY5v6fLjty194vGALawGdIoTjiIP%2FmjgfIrjPlV5Sb0ZChIHd9vGj1hUh9M3%2FgsEAZuvsLqaPpX0pvQML21va6msjUtv5NBLKYe6%2BTaJ1rv5LEWnAXC%2BPmtfuXCti7f2%2BS7SHP2lzGb4vmbrKOCvh07sBdB61tBsSK4yj%2BAyrKeKT%2FoXfjFf%2Bhhsuu4uFT37wxzasB84iHCmiEpyZXRKJ%2FDwFN7kEwhWY3OtiJ6lqisFRkeX20lx6Gj%2BU2qGl3F%2FLwkaiu1cRQp5EeSILjDRtyBlReffBp62AZYAw0NH83NukK7iHnZGsAvhnZcKYYxLAcqSZORcDiM%2B%2BVvyhihIdBkP1EztC20ruX17qf5jfM8UJ28BMMxm65K%2BKUhmKbniTWKs800KspMJCvB6zQn2RlQD%2BG%2FiKPNo6P4wlQEFr0Ra3Prs0Ad8XFN9jqJ7bTfQWqjsJjVB%2Fh7%2FmNYzFbg%2B66eT9892HQisI7w%2FYHdITx8%2FEVstLnNM%2BjL5laSKku4n6ap5A39csaW1i61dT0SqQExWxGmMmcGkadyMBJ0RO5c1n8wD4L8T%2FCUiAVNKhmW1n25fGtes6ak1WLANCsVyReWdqZsISC8BuyPxSNRBSRgBFWHYOBc%2Bjeq79L9IVsBJSqAAmekQ5tzZG2ahJyv%2FpUDKGBMd5PGZZIFFysNsy1YISWFDEOMNEO6CFa3bUCLmChYsbslMeMbYgyW3%2FrSvG2pOBx%2FN%2F3C50QEZURvybVjlyh9eYEzAkb14ZpJM2eIc3gao0dnKuZp4HLwxvzwgF%2FNMLLStVEJy5dBTyJ0taaX1XUftEfQycovHyT0HWrGADC8s%2B8XrlZX3Qu1vBoITfUkXQLYgB5rE5qT5uSfvglNZeepFIagXSq86NfD0glZxEj58Vs4UCC0q4pRXb6lv2epqa6So8EHmdSxtx%2Bin452T8EkbBkUnoOCGQdH91gVfIPdpGll9BpBj5A5SDt14ItYQOe778bVlrp5jrXezwz4kK8%2BeVOnGExuaY0N3R1xAUYc1zzJDC4qLDx7nyTBejS%2Btnxs%2BxKJ7Riq5D9p6Qx%2FkeetqSABwLmhZ4gG0FC5h%2BvFi2%2BMT90ONtRJy9RLK8Lx4z0AXyU%2BNwW5K9yEqPXcKXv0Gtw2EHXttkuSkj6pvHsY0D8DMWikicjKr6pB2QB8ZSwFwNvyitijkisMb%2FWxSSruKYA74Jf7dsGSuPDpjRy7%2BD%2BzvyQia7cs0BPPnqyNy1MB%2FjwjyidXXG%2BWcEkVyRfjnUjVMJqyMIS0VoecFbQrylwvUcuQ%2FzSCxrl%2BJEsEjJ%2Br62yPM7Xhm%2FcwyA0OZBRtznHpGMg4WgcTrhHBWJwD3F%2FnSmHUatvmyRv%2FLL4MJJr5ZA47340kXH4WgNRLA2JG9CRdXW0jgtmQ%2FwEncP65uDMQJ1TU9XaiQ3osXpCYzh3PcJNCvmNqb%2F0SgcNvPvHsRdQRPUSCU33Ld34YqQfxSmWz7Q7%2BajpKoNViE2aanpCQG6%2FDXjQBnvcwOBsGw%2B7wumXbImX5%2BV22re%2F5QlxBHBJrjIJpUi%2BsVlEX5kVReXovDxk0szLcV41TPynqtV3Fg585uP42zQBxv3ZVQR2U8sPw%2B5otyF9Uzz7OEsf%2Fm99vwPaPA3w6cjLS5ap1kebN0yhsfaHyPtFalhJy%2BTB%2BAP5CuhUaXY0oEwhZ9xQsSm5HCIqaxQtUXtGvXH1E7LbQ%2BfDbJP%2F36JlC832rcsKFo8Nl3e3%2BaEvyY3APfCFovvDfa2Y%2B2BYDVQ6HsTEy9fo6fbCGaQER6Fqu6VnY2G6u7H2gb%2FnGoIIk%2FHUDX47D8oeV3oJC9YOQqjHHxDGi3WpGUpXwa01EHeEBud83zfVq8Xc8zgTZPvsAPgyktVR%2BsW%2BisPGo51t%2FUYYhrodJ8XjlSJHp2zM1AmwYPeQLcBw1gSpBvYRlvpt94HcgA6XRVaJkCmdxsGRF6EQKDHNz7GoUTXt%2Br8OQOCDScFHz14DNR2MZPNo9vjGslh1d7A9%2FnxkSb3%2BsyI3h0lzN2nbqaecfyKOqC3qOqxFkAwUnFZVlEfzaHMqqAjdQskKculpwBHvktJbAlz2crROwSkfV3UcHBkMQcjaK72EwkzRMjGCBgA0G2iJf5GmccFBQ4Ll9WSqsq7clmJgEABPdwrfyhRcF%2BPBTomHsD6ocQj3EX3aoaC2BPRnlvuw1dzaGCnqAc6Du%2B6Thn09zMF5z%2FwDX6Mrc%2FmBu9ONrswrsJurXlQjzTOnLY37%2FOPd8LN6J5kLtetQEKOoF1IkN%2FGHPxXaw3YwOaQMHBPme%2FNNB4vRxXK%2Fx6IY4AoTdaOGm2G1EXyqM4bWWs4tabIa9ZfhSoJOlbWKGl2VgdqH07NgeyuQpRxTURPcxHwTgKcjDJl2QkBizI76S%2FyeOqSIs0TdhrcHE5Jirqwo492F4LoAM5HHeym9c2dzjcCVm37p7ByzyytPcUeWmTm860YZZf82oFxBX2Eygg8JTl8TEiy5zML8q6L932wFHRZIgzRavNBHRX5VPJk%2Bct72nY6Kb%2BJ4hLFDmCHfP9uyy728aUbDCwqwXlf37OyeS0uEDEL7faMuOKgwSSOpx8FxXIuS3WvQD7zDF6CAtVMykapVDoxsBS8snofaIj4agGLVrAdU6nsiEr3FF0gQJK%2BF26SWBGglljkmoomet2TPpbbZQw1ZkrnyzL5qw%2B5p5weE3WEkGakSh7ck6%2BnoU1FkkMwja7ELFo%2F3cZ%2BLhYojAl4leQHCVIUoVRuzuEF%2B3WOWbrwohl9KSDSaBwrBvpSOAxgYOlhtUFomre4Wq3QrBfuNJjQorhsX5Jz8tugihW3Zc4vuVhtSuJXMNH5xT5QFFq2EE%2FyBEtbaeTdz%2BRtQ51hW2YMNlGOBNCBAUkysLZduwhJ3YTwGHu7S%2BbUj3Slv1XVrpIECBWvh%2FEjsCR02o8Jk2AhB7MCFjpCD5aDeyq8hPaRb8BOlC7J9YcRP0mkVg09GtjszfuveFN98twCjTHry1IDXBgRGgGCZpJ8Iv2ZGRc%2FhTJhB76NGOa9HR9gLauIE6ZdLGZr94QGhu%2BUby4LEQzgedtjwUXcyTWH5tlfsEcOMrFyOPLDfzB3W0jJ5JMNds2pJF5OFd3TbS7c%2F147lt1igBzskSZGkGnN7GHTbqm70PhHamo8PPNIcfIT962iyj4nic5Q12xHW7%2BKku0C5EdrkhlIhn1c9Ak%2Bo9GhekeOM%2F1A3J9Znd6j5BMCfAfvZLQNryky4UY09flQVPlxR5asRH%2Fd7zNJfxtaOv1wCoqwrxfSTSS6n1Wxkbxc2xqkZYkPk3yNjTigaloY0qOcUcO8XSEsurkR32UhaQDEitrlRXtIRwjv%2BixoFDAxrFDIg4cwUS1q7P1KRtm4Ph%2F8e4RoP%2FZEjPHmsBbQkbpP%2BjU0HV65dmZ8ubKZRSdDJNzjxYqB0FNNk%2FdJ5diZrjfJIsPuh4NAhlT%2BCi6PcDmt4TrarRwxM6%2FocLxPNfRiwXKK6XHapB26AQxd3CYo3HKpJwrSy6iekUCU1pljh7zQMAEFsJrIv3aONqis3a317lxEo0cwC%2BwhVQG%2BL8aE9kPmD4AGlfrJZCt7YZ%2Fq5J%2FArJ5IirewQzLyYAAtLPHqt%2BZ57roqC0182vvbnonpDsU6O8xomzpJxRPZDvpQhu2%2BmDhrVnAqwOMKY8I6JMO5%2BwQBshZjyfqfU6Hw0c9tgp4PoWoNslAvI08mr2M3APWt3sf0Yy2Xzq40vx2K7h4XQAzDCKbNWRCO%2BRkJRdVPaCnJPmcHtPkl0%2BqBTTFgshhFowgfjwQXKU8Tn9iNrO3lLkPUbwN3VD2ayX%2BTCFLsjtowkWnHnKeQhgIEIrGJbB1PCpY7mMSXZhRCeBcKKQ5VKKgLPRTjpSbyPf6dCMIiduKr8t93xQrKHxCbCeeZY%2FiMsGFjiuh4s3pNSvVuZOVkAy7aGByNsRMUXZ%2BP0BcvLVfmmHK10HXlu7alfDKIjlYP%2BjdVhXCrv8ILdRRqwXCfEzONto2UUBCYdYQQUts%2FKj48y11asDbZ8NnebvSmqGs6nF4YCBp8Xb5dcAsetyRu%2B7PYQaOzYv%2F7i%2FxELEBOkDAsymU1zmrGMHMqyEd%2FueAdd30aoFuVxfR7MnB0vLjJjCBEviy8VuAckM9K6F8ePynuE7J0JKMvhwnf3D2w6EZyncPmwxEcKWkgcLh3Hx2ReDdnobTp77rWPAnSh%2FUEvc1tyOALbe3W0SFes8X7kfFCGgwRsAu37wAaLxoelv1l8BqV9l5pLEIpARc5eaZihUlyJCR5ALcdJ3m4uUN1DF4bynLKBFSSv%2FSpo%2FegAeEDCpPcG%2BtI1wkTwhGNN%2FSeQhA9UKPBUo%2FDifB9OEuSPTmr5rW7UdNFohcF569802%2FDR3xm714nVDNZzc0up%2Fvn7DPOXZxWM%2FBqfnZDnDRKawKPYvBNA2JKxvOtYlqUVrrHUbF5f4npOUlgwK7J%2Fb8UQgYkK%2B1%2BrZcyEZtjt1FdT%2FmGti2p%2Fp4H9xLOCFqcjSarh4GtyDLjWxz2v5KS7R87%2F8syWzaFJwwJdHf2pYOaqVN4MfdhoL340VcHih4SjfxlEZJkVO4Zqnjl3mYAizkYB0YDycbmuSAxT62zq%2BrNOxo%2FGwx3h0%2Bf9DwxkJhXLmG4f3h8V%2BVdt7WLTygVgpAVeo6ygS1PdtG65fCBPd8W2k0CSr%2B36bcrAqbsgNGWJ3ftQjx3LadnhU7Ydyj9ypR5q1ofxfEAfJZMkcs8VH0ftCPMgv9OoLgkndEf8Wb2giA9gjDq05IAuHogbjhBm1U4ILX0kUs1bcSfNY5wZDEkZqULVE15eSNDTmpv4Q7nb6R0%2BcLCtq0OEk5TctA0XaPpaQsTYh2nl%2F%2B%2Bsm9GEjWDvnt2%2F8FPtB5fexD1ML%2F1le7PJyDmzQuN0WGHK1awmq14KroxeLfq7Jo9W0Ev09Z0GlBFyGrZVXjyn3Pjy4XlWZoVZhwE21mzeaOwbCchj%2Fz7pKnCDTHGL%2BuJLcVYGPmjIK5HNhhiqzDV0mWMF0tmKOD27%2FBZeNqnbDLYgQ7GjtUL6BbKRiF%2Fi7yaLW%2FYas8qs2Ka5aNt6MaRhGY01CaRrem5xggcuLFTl7HWDNdyauouityFTBgWxid7EpoMvh7CSJ0CVg8%2BWgMH%2BwbiWVhTUziNO8fHhOygI3rb9yliYqezr45EI0otr2NHRxEAGR7WxERtfHUqjHKau%2BQN7l3Ac86tbp4w8klyBcggKU6zhPHotxY3T3a2f9ij%2FIPXgCHOYsCEAZwa9rOxvhzzYRpWf11X%2F2Vv3G0UZO%2Fd1Dv61Nm9xfklcqY855WFUQhv8g8TSl%2Bj0nPYBOPe6WNZow%3D%3D" +
				"&ctl00%24MainContent%24FirstNameTextBox=sreejith" +
				"&ctl00%24MainContent%24LastNameTextBox=sree" +
				"&ctl00%24MainContent%24AddressLineOneTextBox=asdasd" +
				"&ctl00%24MainContent%24AddressLineTwoTextBox=afdasf" +
				"&ctl00%24MainContent%24PostalCodeTextBox=1234" +
				"&ctl00%24MainContent%24CountryDropDownList=AF" +
				"&ctl00%24MainContent%24CardTypeRadioButtonList=MasterCard" +
				"&ctl00%24MainContent%24CardNumberTextBox=1234567890123456" +
				"&ctl00%24MainContent%24SubmitButton=Submit";
		byte[] binarySearchPattern0042_0 = Base64Decoder.decodeToBytes("JTJGd0VQRHdVTExURTFPVE14TURneU16QVBaQllDWmc5a0ZnSUNBdzlrRmdZQ0RROWtGZ0ptRDJRV0FnSUJEeFlDSGdSVVpYaDBCUWsySUhScFkydGxkSE5rQWhRUFpCWUNBZ0VQWkJZQ0FnRVBaQllDQWdFUFpCWUVaZzlrRmdKbUR3OFdBaDhBQlFFMlpHUUNBUTlrRmdKbUR3OFdBaDhBQlFRME1EQXdaR1FDR1E4V0FoNExYeUZKZEdWdFEyOTFiblFDQVJZQ1pnOWtGZ0lDQVE4V0FoNERjM0pqQlJoJTJCTDBsdFlXZGxjeTlNYjJkdmN5OWhlblZ5WlM1d2JtZGtaSzdYNDJQcFlYd2tsN1hJYmw0d2w1QzA2YmFJ");		// note: the search pattern value is base 64 encoded. decoded value = %2FwEPDwULLTE1OTMxMDgyMzAPZBYCZg9kFgICAw9kFgYCDQ9kFgJmD2QWAgIBDxYCHgRUZXh0BQk2IHRpY2tldHNkAhQPZBYCAgEPZBYCAgEPZBYCAgEPZBYEZg9kFgJmDw8WAh8ABQE2ZGQCAQ9kFgJmDw8WAh8ABQQ0MDAwZGQCGQ8WAh4LXyFJdGVtQ291bnQCARYCZg9kFgICAQ8WAh4Dc3JjBRh%2BL0ltYWdlcy9Mb2dvcy9henVyZS5wbmdkZK7X42PpYXwkl7XIbl4wl5C06baI
		requestContent0042 = new String(Lib.binaryReplace(requestContent0042.getBytes(), binarySearchPattern0042_0, java.net.URLEncoder.encode(vVIEWSTATE_2).getBytes(), 0));		// search within the request content for a binary pattern and replace it with a variable value
		byte[] binarySearchPattern0042_1 = Base64Decoder.decodeToBytes("JTJGd0VkQVBzQjc4Z2xyZ052JTJCQnA5V053MUNmTmVsVjI3azJhamFydUZMWU5XUXglMkJIZUZFcWt2ZHNZNXY2ZkxqdHkxOTR2R0FMYXdHZElvVGppSVAlMkZtamdmSXJqUGxWNVNiMFpDaElIZDl2R2oxaFVoOU0zJTJGZ3NFQVp1dnNMcWFQcFgwcHZRTUwyMXZhNm1zalV0djVOQkxLWWU2JTJCVGFKMXJ2NUxFV25BWEMlMkJQbXRmdVhDdGk3ZjIlMkJTN1NIUDJsekdiNHZtYnJLT0N2aDA3c0JkQjYxdEJzU0s0eWolMkJBeXJLZUtUJTJGb1hmakZmJTJCaGhzdXU0dUZUMzd3eHphc0I4NGlIQ21pRXB5WlhSS0olMkZEd0ZON2tFd2hXWTNPdGlKNmxxaXNGUmtlWDIwbHg2R2olMkJVMnFHbDNGJTJGTHdrYWl1MWNSUXA1RWVTSUxqRFJ0eUJsUmVmZkJwNjJBWllBdzBOSDgzTnVrSzdpSG5aR3NBdmhuWmNLWVl4TEFjcVNaT1JjRGlNJTJCJTJCVnZ5aGloSWRCa1AxRXp0QzIwcnVYMTdxZjVqZk04VUoyOEJNTXhtNjVLJTJCS1VobUtibmlUV0tzODAwS3NwTUpDdkI2elFuMlJsUUQlMkJHJTJGaUtQTm82UDR3bFFFRnIwUmEzUHJzMEFkOFhGTjlqcUo3YlRmUVdxanNKalZCJTJGaDclMkZtTll6RmJnJTJCNjZlVDk4OTJIUWlzSTd3JTJGWUhkSVR4OCUyRkVWc3RMbk5NJTJCakw1bGFTS2t1NG42YXA1QTM5Y3NhVzFpNjFkVDBTcVFFeFd4R21NbWNHa2FkeU1CSjBSTzVjMW44d0Q0TDhUJTJGQ1VpQVZOS2htVzFuMjVmR3RlczZhazFXTEFOQ3NWeVJlV2RxWnNJU0M4QnV5UHhTTlJCU1JnQkZXSFlPQmMlMkJqZXE3OUw5SVZzQkpTcUFBbWVrUTV0elpHMmFoSnl2JTJGcFVES0dCTWQ1UEdaWklGRnlzTnN5MVlJU1dGREVPTU5FTzZDRmEzYlVDTG1DaFlzYnNsTWVNYllneVczJTJGclN2RzJwT0J4JTJGTiUyRjNDNTBRRVpVUnZ5YlZqbHloOWVZRXpBa2IxNFpwSk0yZUljM2dhbzBkbkt1WnA0SEx3eHZ6d2dGJTJGTk1MTFN0VkVKeTVkQlR5SjB0YWFYMVhVZnRFZlF5Y292SHlUMEhXckdBREM4cyUyQjhYcmxaWDNRdTF2Qm9JVGZVa1hRTFlnQjVyRTVxVDV1U2Z2Z2xOWmVlcEZJYWdYU3E4Nk5mRDBnbFp4RWo1OFZzNFVDQzBxNHBSWGI2bHYyZXBxYTZTbzhFSG1kU3h0eCUyQmluNDUyVDhFa2JCa1Vub09DR1FkSDkxZ1ZmSVBkcEdsbDlCcEJqNUE1U0R0MTRJdFlRT2U3NzhiVmxycDVqclhlend6NGtLOCUyQmVWT25HRXh1YVkwTjNSMXhBVVljMXp6SkRDNHFMRHg3bnlUQmVqUyUyQnRueHMlMkJ4S0o3UmlxNUQ5cDZReCUyRmtlZXRxU0FCd0xtaFo0Z0cwRkM1aCUyQnZGaTIlMkJNVDkwT050Ukp5OVJMSzhMeDR6MEFYeVUlMkJOd1c1Szl5RXFQWGNLWHYwR3R3MkVIWHR0a3VTa2o2cHZIc1kwRDhETVdpa2ljaktyNnBCMlFCOFpTd0Z3TnZ5aXRpamtpc01iJTJGV3hTU3J1S1lBNzRKZjdkc0dTdVBEcGpSeTclMkJEJTJCenZ5UWlhN2NzMEJQUG5xeU55MU1CJTJGandqeWlkWFhHJTJCV2NFa1Z5UmZqblVqVk1KcXlNSVMwVm9lY0ZiUXJ5bHd2VWN1USUyRnpTQ3hybCUyQkpFc0VqSiUyQnI2MnlQTTdYaG0lMkZjd3lBME9aQlJ0em5IcEdNZzRXZ2NUcmhIQldKd0QzRiUyRm5TbUhVYXR2bXlSdiUyRkxMNE1KSnI1WkE0NzM0MGtYSDRXZ05STEEySkc5Q1JkWFcwamd0bVElMkZ3RW5jUDY1dURNUUoxVFU5WGFpUTNvc1hwQ1l6aDNQY0pOQ3ZtTnFiJTJGMFNnY052UHZIc1JkUVJQVVNDVTMzTGQzNFlxUWZ4U21XejdRNyUyQmFqcEtvTlZpRTJhYW5wQ1FHNiUyRkRYalFCbnZjd09Cc0d3JTJCN3d1bVhiSW1YNSUyQlYyMnJlJTJGNVFseEJIQkpyaklKcFVpJTJCc1ZsRVg1a1ZSZVhvdkR4azBzekxjVjQxVFB5bnF0VjNGZzU4NXVQNDJ6UUJ4djNaVlFSMlU4c1B3JTJCNW90eUY5VXp6N09Fc2YlMkZtOTl2d1BhUEEzdzZjakxTNWFwMWtlYk4weWhzZmFIeVB0RmFsaEp5JTJCVEIlMkJBUDVDdWhVYVhZMG9Fd2haOXhRc1NtNUhDSXFheFF0VVh0R3ZYSDFFN0xiUSUyQmZEYkpQJTJGMzZKbEM4MzJyY3NLRm84TmwzZTMlMkJhRXZ5WTNBUGZDRm92dkRmYTJZJTJCMkJZRFZRNkhzVEV5OWZvNmZiQ0dhUUVSNkZxdTZWblkyRzZ1N0gyZ2IlMkZuR29JSWslMkZIVURYNDdEOG9lVjNvSkM5WU9RcWpISHhER2kzV3BHVXBYd2EwMUVIZUVCdWQ4M3pmVnE4WGM4emdUWlB2c0FQZ3lrdFZSJTJCc1clMkJpc1BHbzUxdCUyRlVZWWhyb2RKOFhqbFNKSHAyek0xQW13WVBlUUxjQncxZ1NwQnZZUmx2cHQ5NEhjZ0E2WFJWYUprQ21keHNHUkY2RVFLREhOejdHb1VUWHQlMkJyOE9RT0NEU2NGSHoxNEROUjJNWlBObzl2akdzbGgxZDdBOSUyRm54a1NiMyUyQnN5STNoMGx6TjJuYnFhZWNmeUtPcUMzcU9xeEZrQXdVbkZaVmxFZnphSE1xcUFqZFFza0tjdWxwd0JIdmt0SmJBbHoyY3JST3dTa2ZWM1VjSEJrTVFjamFLNzJFd2t6Uk1qR0NCZ0EwRzJpSmY1R21jY0ZCUTRMbDlXU3FzcTdjbG1KZ0VBQlBkd3JmeWhSY0YlMkJQQlRvbUhzRDZvY1FqM0VYM2FvYUMyQlBSbmx2dXcxZHphR0NucUFjNkR1JTJCNlRobjA5ek1GNXolMkZ3RFg2TXJjJTJGbUJ1OU9OcnN3cnNKdXJYbFFqelRPbkxZMzclMkZPUGQ4TE42SjVrTHRldFFFS09vRjFJa04lMkZHSFB4WGF3M1l3T2FRTUhCUG1lJTJGTk5CNHZSeFhLJTJGeDZJWTRBb1RkYU9HbTJHMUVYeXFNNGJXV3M0dGFiSWE5WmZoU29KT2xiV0tHbDJWZ2RxSDA3TmdleXVRcFJ4VFVSUGN4SHdUZ0tjakRKbDJRa0Jpekk3NlMlMkZ5ZU9xU0lzMFRkaHJjSEU1SmlycXdvNDkyRjRMb0FNNUhIZXltOWMyZHpqY0NWbTM3cDdCeXp5eXRQY1VlV21UbTg2MFlaWmY4Mm9GeEJYMkV5Z2c4SlRsOFRFaXk1ek1MOHE2TDkzMndGSFJaSWd6UmF2TkJIUlg1VlBKayUyQmN0NzJuWTZLYiUyQko0aExGRG1DSGZQOXV5eTcyOGFVYkRDd3F3WGxmMzdPeWVTMHVFREVMN2ZhTXVPS2d3U1NPcHg4RnhYSXVTM1d2UUQ3ekRGNkNBdFZNeWthcFZEb3hzQlM4c25vZmFJajRhZ0dMVnJBZFU2bnNpRXIzRkYwZ1FKSyUyQkYyNlNXQkdnbGxqa21vb21ldDJUUHBiYlpRdzFaa3JueXpMNXF3JTJCNXA1d2VFM1dFa0dha1NoN2NrNiUyQm5vVTFGa2tNd2phN0VMRm8lMkYzY1olMkJMaFlvakFsNGxlUUhDVklVb1ZSdXp1RUYlMkIzV09XYnJ3b2hsOUtTRFNhQndyQnZwU09BeGdZT2xodFVGb21yZTRXcTNRckJmdU5KalFvcmhzWDVKejh0dWdpaFczWmM0dnVWaHRTdUpYTU5INXhUNVFGRnEyRUUlMkZ5QkV0YmFlVGR6JTJCUnRRNTFoVzJZTU5sR09CTkNCQVVreXNMWmR1d2hKM1lUd0dIdTdTJTJCYlVqM1NsdjFYVnJwSUVDQld2aCUyRkVqc0NSMDJvOEprMkFoQjdNQ0ZqcENENWFEZXlxOGhQYVJiOEJPbEM3SjlZY1JQMG1rVmcwOUd0anN6ZnV2ZUZOOTh0d0NqVEhyeTFJRFhCZ1JHZ0dDWnBKOEl2MlpHUmMlMkZoVEpoQjc2TkdPYTlIUjlnTGF1SUU2WmRMR1pyOTRRR2h1JTJCVWJ5NExFUXpnZWR0andVWGN5VFdINXRsZnNFY09NckZ5T1BMRGZ6QjNXMGpKNUpNTmRzMnBKRjVPRmQzVGJTN2MlMkYxNDdsdDFpZ0J6c2tTWkdrR25ON0dIVGJxbTcwUGhIYW1vOFBQTkljZklUOTYyaXlqNG5pYzVRMTJ4SFc3JTJCS2t1MEM1RWRya2hsSWhuMWM5QWslMkJvOUdoZWtlT00lMkYxQTNKOVpuZDZqNUJNQ2ZBZnZaTFFOcnlreTRVWTA5ZmxRVlBseFI1YXNSSCUyRmQ3ek5KZnh0YU92MXdDb3F3cnhmU1RTUzZuMVd4a2J4YzJ4cWtaWWtQazN5TmpUaWdhbG9ZMHFPY1VjTzhYU0VzdXJrUjMyVWhhUURFaXRybFJYdElSd2p2JTJCaXhvRkRBeHJGRElnNGN3VVMxcTdQMUtSdG00UGglMkY4ZTRSb1AlMkZaRWpQSG1zQmJRa2JwUCUyQmpVMEhWNjVkbVo4dWJLWlJTZERKTnpqeFlxQjBGTk5rJTJGZEo1ZGlacmpmSklzUHVoNE5BaGxUJTJCQ2k2UGNEbXQ0VHJhclJ3eE02JTJGb2NMeFBOZlJpd1hLSzZYSGFwQjI2QVF4ZDNDWW8zSEtwSndyU3k2aWVrVUNVMXBsamg3elFNQUVGc0pySXYzYU9OcWlzM2EzMTdseEVvMGN3QyUyQndoVlFHJTJCTDhhRTlrUG1ENEFHbGZySlpDdDdZWiUyRnE1SiUyRkFySjVJaXJld1F6THlZQUF0TFBIcXQlMkJaNTdyb3FDMDE4MnZ2Ym5vbnBEc1U2Tzh4b216cEp4UlBaRHZwUWh1MiUyQm1EaHJWbkFxd09NS1k4STZKTU81JTJCd1FCc2haanlmcWZVNkh3MGM5dGdwNFBvV29Oc2xBdkkwOG1yMk0zQVBXdDNzZjBZeTJYenE0MHZ4Mks3aDRYUUF6RENLYk5XUkNPJTJCUmtKUmRWUGFDbkpQbWNIdFBrbDAlMkJxQlRURmdzaGhGb3dnZmp3UVhLVThUbjlpTnJPM2xMa1BVYndOM1ZEMmF5WCUyQlRDRkxzanRvd2tXbkhuS2VRaGdJRUlyR0piQjFQQ3BZN21NU1haaFJDZUJjS0tRNVZLS2dMUFJUanBTYnlQZjZkQ01JaWR1S3I4dDkzeFFyS0h4Q2JDZWVaWSUyRmlNc0dGaml1aDRzM3BOU3ZWdVpPVmtBeTdhR0J5TnNSTVVYWiUyQlAwQmN2TFZmbW1ISzEwSFhsdTdhbGZES0lqbFlQJTJCamRWaFhDcnY4SUxkUlJxd1hDZkV6T050bzJVVUJDWWRZUVFVdHMlMkZLajQ4eTExYXNEYlo4Tm5lYnZTbXFHczZuRjRZQ0JwOFhiNWRjQXNldHlSdSUyQjdQWVFhT3pZdiUyRjdpJTJGeEVMRUJPa0RBc3ltVTF6bXJHTUhNcXlFZCUyRnVlQWRkMzBhb0Z1VnhmUjdNbkIwdkxqSmpDQkV2aXk4VnVBY2tNOUs2RjhlUHludUU3SjBKS012aHduZjNEMnc2RVp5bmNQbXd4RWNLV2tnY0xoM0h4MlJlRGRub2JUcDc3cldQQW5TaCUyRlVFdmMxdHlPQUxiZTNXMFNGZXM4WDdrZkZDR2d3UnNBdTM3d0FhTHhvZWx2MWw4QnFWOWw1cExFSXBBUmM1ZWFaaWhVbHlKQ1I1QUxjZEozbTR1VU4xREY0YnluTEtCRlNTdiUyRlNwbyUyRmVnQWVFRENwUGNHJTJCdEkxd2tUd2hHTk4lMkZTZVFoQTlVS1BCVW8lMkZEaWZCOU9FdVNQVG1yNXJXN1VkTkZvaGNGNTY5ODAyJTJGRFIzeG03MTRuVkROWnpjMHVwJTJGdm43RFBPWFp4V00lMkZCcWZuWkRuRFJLYXdLUFl2Qk5BMkpLeHZPdFlscVVWcnJIVWJGNWY0bnBPVWxnd0s3SiUyRmI4VVFnWWtLJTJCMSUyQnJaY3lFWnRqdDFGZFQlMkZtR3RpMnAlMkZwNEg5eExPQ0ZxY2pTYXJoNEd0eURMald4ejJ2NUtTN1I4NyUyRjhzeVd6YUZKd3dKZEhmMnBZT2FxVk40TWZkaG9MMzQwVmNIaWg0U2pmeGxFWkprVk80WnFuamwzbVlBaXprWUIwWUR5Y2JtdVNBeFQ2MnpxJTJCck5PeG8lMkZHd3gzaDAlMkJmOUR3eGtKaFhMbUc0ZjNoOFYlMkJWZHQ3V0xUeWdWZ3BBVmVvNnlnUzFQZHRHNjVmQ0JQZDhXMmswQ1NyJTJCMzZiY3JBcWJzZ05HV0ozZnRRangzTGFkbmhVN1lkeWo5eXBSNXExb2Z4ZkVBZkpaTWtjczhWSDBmdENQTWd2OU9vTGdrbmRFZjhXYjJnaUE5Z2pEcTA1SUF1SG9nYmpoQm0xVTRJTFgwa1VzMWJjU2ZOWTV3WkRFa1pxVUxWRTE1ZVNORFRtcHY0UTduYjZSMCUyQmNMQ3RxME9FazVUY3RBMFhhUHBhUXNUWWgybmwlMkYlMkIlMkJzbTlHRWpXRHZudDIlMkY4RlB0QjVmZXhEMU1MJTJGMWxlN1BKeURtelF1TjBXR0hLMWF3bXExNEtyb3hlTGZxN0pvOVcwRXYwOVowR2xCRnlHclpWWGp5bjNQank0WGxXWm9WWmh3RTIxbXplYU93YkNjaGolMkZ6N3BLbkNEVEhHTCUyQnVKTGNWWUdQbWpJSzVITmhoaXF6RFYwbVdNRjB0bUtPRDI3JTJGQlplTnFuYkRMWWdRN0dqdFVMNkJiS1JpRiUyRmk3eWFMVyUyRllhczhxczJLYTVhTnQ2TWFSaEdZMDFDYVJyZW01eGdnY3VMRlRsN0hXRE5keWF1b3VpdHlGVEJnV3hpZDdFcG9Ndmg3Q1NKMENWZzglMkJXZ01IJTJCd2JpV1ZoVFV6aU5POGZIaE95Z0kzcmI5eWxpWXFlenI0NUVJMG90cjJOSFJ4RUFHUjdXeEVSdGZIVXFqSEthdSUyQlFON2wzQWM4NnRicDR3OGtseUJjZ2dLVTZ6aFBIb3R4WTNUM2EyZjlpaiUyRklQWGdDSE9Zc0NFQVp3YTlyT3h2aHp6WVJwV2YxMVglMkYyVnYzRzBVWk8lMkZkMUR2NjFObTl4ZmtsY3FZODU1V0ZVUWh2OGc4VFNsJTJCajBuUFlCT1BlNldOWm93JTNEJTNE");		// note: the search pattern value is base 64 encoded. decoded value = %2FwEdAPsB78glrgNv%2BBp9WNw1CfNelV27k2ajaruFLYNWQx%2BHeFEqkvdsY5v6fLjty194vGALawGdIoTjiIP%2FmjgfIrjPlV5Sb0ZChIHd9vGj1hUh9M3%2FgsEAZuvsLqaPpX0pvQML21va6msjUtv5NBLKYe6%2BTaJ1rv5LEWnAXC%2BPmtfuXCti7f2%2BS7SHP2lzGb4vmbrKOCvh07sBdB61tBsSK4yj%2BAyrKeKT%2FoXfjFf%2Bhhsuu4uFT37wxzasB84iHCmiEpyZXRKJ%2FDwFN7kEwhWY3OtiJ6lqisFRkeX20lx6Gj%2BU2qGl3F%2FLwkaiu1cRQp5EeSILjDRtyBlReffBp62AZYAw0NH83NukK7iHnZGsAvhnZcKYYxLAcqSZORcDiM%2B%2BVvyhihIdBkP1EztC20ruX17qf5jfM8UJ28BMMxm65K%2BKUhmKbniTWKs800KspMJCvB6zQn2RlQD%2BG%2FiKPNo6P4wlQEFr0Ra3Prs0Ad8XFN9jqJ7bTfQWqjsJjVB%2Fh7%2FmNYzFbg%2B66eT9892HQisI7w%2FYHdITx8%2FEVstLnNM%2BjL5laSKku4n6ap5A39csaW1i61dT0SqQExWxGmMmcGkadyMBJ0RO5c1n8wD4L8T%2FCUiAVNKhmW1n25fGtes6ak1WLANCsVyReWdqZsISC8BuyPxSNRBSRgBFWHYOBc%2Bjeq79L9IVsBJSqAAmekQ5tzZG2ahJyv%2FpUDKGBMd5PGZZIFFysNsy1YISWFDEOMNEO6CFa3bUCLmChYsbslMeMbYgyW3%2FrSvG2pOBx%2FN%2F3C50QEZURvybVjlyh9eYEzAkb14ZpJM2eIc3gao0dnKuZp4HLwxvzwgF%2FNMLLStVEJy5dBTyJ0taaX1XUftEfQycovHyT0HWrGADC8s%2B8XrlZX3Qu1vBoITfUkXQLYgB5rE5qT5uSfvglNZeepFIagXSq86NfD0glZxEj58Vs4UCC0q4pRXb6lv2epqa6So8EHmdSxtx%2Bin452T8EkbBkUnoOCGQdH91gVfIPdpGll9BpBj5A5SDt14ItYQOe778bVlrp5jrXezwz4kK8%2BeVOnGExuaY0N3R1xAUYc1zzJDC4qLDx7nyTBejS%2Btnxs%2BxKJ7Riq5D9p6Qx%2FkeetqSABwLmhZ4gG0FC5h%2BvFi2%2BMT90ONtRJy9RLK8Lx4z0AXyU%2BNwW5K9yEqPXcKXv0Gtw2EHXttkuSkj6pvHsY0D8DMWikicjKr6pB2QB8ZSwFwNvyitijkisMb%2FWxSSruKYA74Jf7dsGSuPDpjRy7%2BD%2BzvyQia7cs0BPPnqyNy1MB%2FjwjyidXXG%2BWcEkVyRfjnUjVMJqyMIS0VoecFbQrylwvUcuQ%2FzSCxrl%2BJEsEjJ%2Br62yPM7Xhm%2FcwyA0OZBRtznHpGMg4WgcTrhHBWJwD3F%2FnSmHUatvmyRv%2FLL4MJJr5ZA47340kXH4WgNRLA2JG9CRdXW0jgtmQ%2FwEncP65uDMQJ1TU9XaiQ3osXpCYzh3PcJNCvmNqb%2F0SgcNvPvHsRdQRPUSCU33Ld34YqQfxSmWz7Q7%2BajpKoNViE2aanpCQG6%2FDXjQBnvcwOBsGw%2B7wumXbImX5%2BV22re%2F5QlxBHBJrjIJpUi%2BsVlEX5kVReXovDxk0szLcV41TPynqtV3Fg585uP42zQBxv3ZVQR2U8sPw%2B5otyF9Uzz7OEsf%2Fm99vwPaPA3w6cjLS5ap1kebN0yhsfaHyPtFalhJy%2BTB%2BAP5CuhUaXY0oEwhZ9xQsSm5HCIqaxQtUXtGvXH1E7LbQ%2BfDbJP%2F36JlC832rcsKFo8Nl3e3%2BaEvyY3APfCFovvDfa2Y%2B2BYDVQ6HsTEy9fo6fbCGaQER6Fqu6VnY2G6u7H2gb%2FnGoIIk%2FHUDX47D8oeV3oJC9YOQqjHHxDGi3WpGUpXwa01EHeEBud83zfVq8Xc8zgTZPvsAPgyktVR%2BsW%2BisPGo51t%2FUYYhrodJ8XjlSJHp2zM1AmwYPeQLcBw1gSpBvYRlvpt94HcgA6XRVaJkCmdxsGRF6EQKDHNz7GoUTXt%2Br8OQOCDScFHz14DNR2MZPNo9vjGslh1d7A9%2FnxkSb3%2BsyI3h0lzN2nbqaecfyKOqC3qOqxFkAwUnFZVlEfzaHMqqAjdQskKculpwBHvktJbAlz2crROwSkfV3UcHBkMQcjaK72EwkzRMjGCBgA0G2iJf5GmccFBQ4Ll9WSqsq7clmJgEABPdwrfyhRcF%2BPBTomHsD6ocQj3EX3aoaC2BPRnlvuw1dzaGCnqAc6Du%2B6Thn09zMF5z%2FwDX6Mrc%2FmBu9ONrswrsJurXlQjzTOnLY37%2FOPd8LN6J5kLtetQEKOoF1IkN%2FGHPxXaw3YwOaQMHBPme%2FNNB4vRxXK%2Fx6IY4AoTdaOGm2G1EXyqM4bWWs4tabIa9ZfhSoJOlbWKGl2VgdqH07NgeyuQpRxTURPcxHwTgKcjDJl2QkBizI76S%2FyeOqSIs0TdhrcHE5Jirqwo492F4LoAM5HHeym9c2dzjcCVm37p7ByzyytPcUeWmTm860YZZf82oFxBX2Eygg8JTl8TEiy5zML8q6L932wFHRZIgzRavNBHRX5VPJk%2Bct72nY6Kb%2BJ4hLFDmCHfP9uyy728aUbDCwqwXlf37OyeS0uEDEL7faMuOKgwSSOpx8FxXIuS3WvQD7zDF6CAtVMykapVDoxsBS8snofaIj4agGLVrAdU6nsiEr3FF0gQJK%2BF26SWBGglljkmoomet2TPpbbZQw1ZkrnyzL5qw%2B5p5weE3WEkGakSh7ck6%2BnoU1FkkMwja7ELFo%2F3cZ%2BLhYojAl4leQHCVIUoVRuzuEF%2B3WOWbrwohl9KSDSaBwrBvpSOAxgYOlhtUFomre4Wq3QrBfuNJjQorhsX5Jz8tugihW3Zc4vuVhtSuJXMNH5xT5QFFq2EE%2FyBEtbaeTdz%2BRtQ51hW2YMNlGOBNCBAUkysLZduwhJ3YTwGHu7S%2BbUj3Slv1XVrpIECBWvh%2FEjsCR02o8Jk2AhB7MCFjpCD5aDeyq8hPaRb8BOlC7J9YcRP0mkVg09GtjszfuveFN98twCjTHry1IDXBgRGgGCZpJ8Iv2ZGRc%2FhTJhB76NGOa9HR9gLauIE6ZdLGZr94QGhu%2BUby4LEQzgedtjwUXcyTWH5tlfsEcOMrFyOPLDfzB3W0jJ5JMNds2pJF5OFd3TbS7c%2F147lt1igBzskSZGkGnN7GHTbqm70PhHamo8PPNIcfIT962iyj4nic5Q12xHW7%2BKku0C5EdrkhlIhn1c9Ak%2Bo9GhekeOM%2F1A3J9Znd6j5BMCfAfvZLQNryky4UY09flQVPlxR5asRH%2Fd7zNJfxtaOv1wCoqwrxfSTSS6n1Wxkbxc2xqkZYkPk3yNjTigaloY0qOcUcO8XSEsurkR32UhaQDEitrlRXtIRwjv%2BixoFDAxrFDIg4cwUS1q7P1KRtm4Ph%2F8e4RoP%2FZEjPHmsBbQkbpP%2BjU0HV65dmZ8ubKZRSdDJNzjxYqB0FNNk%2FdJ5diZrjfJIsPuh4NAhlT%2BCi6PcDmt4TrarRwxM6%2FocLxPNfRiwXKK6XHapB26AQxd3CYo3HKpJwrSy6iekUCU1pljh7zQMAEFsJrIv3aONqis3a317lxEo0cwC%2BwhVQG%2BL8aE9kPmD4AGlfrJZCt7YZ%2Fq5J%2FArJ5IirewQzLyYAAtLPHqt%2BZ57roqC0182vvbnonpDsU6O8xomzpJxRPZDvpQhu2%2BmDhrVnAqwOMKY8I6JMO5%2BwQBshZjyfqfU6Hw0c9tgp4PoWoNslAvI08mr2M3APWt3sf0Yy2Xzq40vx2K7h4XQAzDCKbNWRCO%2BRkJRdVPaCnJPmcHtPkl0%2BqBTTFgshhFowgfjwQXKU8Tn9iNrO3lLkPUbwN3VD2ayX%2BTCFLsjtowkWnHnKeQhgIEIrGJbB1PCpY7mMSXZhRCeBcKKQ5VKKgLPRTjpSbyPf6dCMIiduKr8t93xQrKHxCbCeeZY%2FiMsGFjiuh4s3pNSvVuZOVkAy7aGByNsRMUXZ%2BP0BcvLVfmmHK10HXlu7alfDKIjlYP%2BjdVhXCrv8ILdRRqwXCfEzONto2UUBCYdYQQUts%2FKj48y11asDbZ8NnebvSmqGs6nF4YCBp8Xb5dcAsetyRu%2B7PYQaOzYv%2F7i%2FxELEBOkDAsymU1zmrGMHMqyEd%2FueAdd30aoFuVxfR7MnB0vLjJjCBEviy8VuAckM9K6F8ePynuE7J0JKMvhwnf3D2w6EZyncPmwxEcKWkgcLh3Hx2ReDdnobTp77rWPAnSh%2FUEvc1tyOALbe3W0SFes8X7kfFCGgwRsAu37wAaLxoelv1l8BqV9l5pLEIpARc5eaZihUlyJCR5ALcdJ3m4uUN1DF4bynLKBFSSv%2FSpo%2FegAeEDCpPcG%2BtI1wkTwhGNN%2FSeQhA9UKPBUo%2FDifB9OEuSPTmr5rW7UdNFohcF569802%2FDR3xm714nVDNZzc0up%2Fvn7DPOXZxWM%2FBqfnZDnDRKawKPYvBNA2JKxvOtYlqUVrrHUbF5f4npOUlgwK7J%2Fb8UQgYkK%2B1%2BrZcyEZtjt1FdT%2FmGti2p%2Fp4H9xLOCFqcjSarh4GtyDLjWxz2v5KS7R87%2F8syWzaFJwwJdHf2pYOaqVN4MfdhoL340VcHih4SjfxlEZJkVO4Zqnjl3mYAizkYB0YDycbmuSAxT62zq%2BrNOxo%2FGwx3h0%2Bf9DwxkJhXLmG4f3h8V%2BVdt7WLTygVgpAVeo6ygS1PdtG65fCBPd8W2k0CSr%2B36bcrAqbsgNGWJ3ftQjx3LadnhU7Ydyj9ypR5q1ofxfEAfJZMkcs8VH0ftCPMgv9OoLgkndEf8Wb2giA9gjDq05IAuHogbjhBm1U4ILX0kUs1bcSfNY5wZDEkZqULVE15eSNDTmpv4Q7nb6R0%2BcLCtq0OEk5TctA0XaPpaQsTYh2nl%2F%2B%2Bsm9GEjWDvnt2%2F8FPtB5fexD1ML%2F1le7PJyDmzQuN0WGHK1awmq14KroxeLfq7Jo9W0Ev09Z0GlBFyGrZVXjyn3Pjy4XlWZoVZhwE21mzeaOwbCchj%2Fz7pKnCDTHGL%2BuJLcVYGPmjIK5HNhhiqzDV0mWMF0tmKOD27%2FBZeNqnbDLYgQ7GjtUL6BbKRiF%2Fi7yaLW%2FYas8qs2Ka5aNt6MaRhGY01CaRrem5xggcuLFTl7HWDNdyauouityFTBgWxid7EpoMvh7CSJ0CVg8%2BWgMH%2BwbiWVhTUziNO8fHhOygI3rb9yliYqezr45EI0otr2NHRxEAGR7WxERtfHUqjHKau%2BQN7l3Ac86tbp4w8klyBcggKU6zhPHotxY3T3a2f9ij%2FIPXgCHOYsCEAZwa9rOxvhzzYRpWf11X%2F2Vv3G0UZO%2Fd1Dv61Nm9xfklcqY855WFUQhv8g8TSl%2Bj0nPYBOPe6WNZow%3D%3D
		requestContent0042 = new String(Lib.binaryReplace(requestContent0042.getBytes(), binarySearchPattern0042_1, java.net.URLEncoder.encode(vEVENTVALIDATION_1).getBytes(), 0));		// search within the request content for a binary pattern and replace it with a variable value
		requestContent0042 = Lib.replaceTextPattern(requestContent0042, "X1D7lKVFLKxnD6o_HB8q5Ns9XEjJFfkeGqyX9qfSrRiknf_6dIU2GcQBEZJC2_2s5c4fb8f25Wy4fcw19HArtH0QotjOiPpKlQEmmXaEa9FDBZ8n0", vPREVIOUSPAGE_2, 0);		// search and replace content fragment "X1D7lKVFLKxnD6o_HB8q5Ns9XEjJFfkeGqyX9qfSrRiknf_6dIU2GcQBEZJC2_2s5c4fb8f25Wy4fcw19HArtH0QotjOiPpKlQEmmXaEa9FDBZ8n0" with variable 'vPREVIOUSPAGE_2' on all occurrences

		String requestHeader0042 = "POST " + requestFile0042 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0042.length() + "\r\n" + 		// Content-Length: 6649
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0042, requestHost0042, requestPort0042, requestHeader0042, requestContent0042.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0042 = null;		// support garbage collector to reduce memory
		requestContent0042 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 4106
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Thanks a lot for your order. Here is your receipt.");		// Test [42] <- Index 42
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [43] <- WEB ADMIN Index 53 ---
		proxyDataRecordId =1564998946208L;
		log();
		log("# title: Home Page");
		String requestProt0043 = "http";
		String requestHost0043 = "cldemo.apicasystem.com";
		int    requestPort0043 = 80;
		String requestFile0043 = "/Default.aspx";
		String requestHeader0043 = "GET " + requestFile0043 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0043, requestHost0043, requestPort0043, requestHeader0043, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0043 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 3609
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "function __doPostBack(eventTarget, eventArgument) {");		// Test [43] <- Index 43
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'vVIEWSTATE_3'
			vVIEWSTATE_3 = htmlContentParser.getFormTable().getForm(0).getFormItemValue("__VIEWSTATE");		// recorded value = /wEPDwUKLTE3MTc0ODk1Ng9kFgJmD2QWAgIDD2QWCAIND2QWAmYPZBYCAgEPFgIeBFRleHQFCTAgdGlja2V0c2QCDg8WAh4FY2xhc3MFBmFjdGl2ZWQCFA9kFgICAQ8WAh4Dc3JjBRB+L0ltYWdlcy9pbWcuanBnZAIZDxYCHgtfIUl0ZW1Db3VudAIBFgJmD2QWAgIBDxYCHwIFGH4vSW1hZ2VzL0xvZ29zL2F6dXJlLnBuZ2RkeHuGN+DHm7mHBl+XgQcstj+Opdc=
			log("<<< vVIEWSTATE_3 = " + vVIEWSTATE_3);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && vVIEWSTATE_3!= null && vVIEWSTATE_3.trim().length() == 0)
			{
				vVIEWSTATE_3 = "";
				log("runtime note: the extraction of a new value for the variable 'vVIEWSTATE_3' ends up with an empty string - a substitute value was set");
				log("<<< vVIEWSTATE_3 = " + vVIEWSTATE_3);
			}
		}
		catch (Exception e) { vVIEWSTATE_3 = null; log(e); }
		if (vVIEWSTATE_3 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vVIEWSTATE_3' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [44] <- WEB ADMIN Index 59 ---
		proxyDataRecordId =1564999026217L;
		log();
		log("# title: Home Page");
		String requestProt0044 = "http";
		String requestHost0044 = "cldemo.apicasystem.com";
		int    requestPort0044 = 80;
		String requestFile0044 = "/";
		String requestHeader0044 = "GET " + requestFile0044 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0044, requestHost0044, requestPort0044, requestHeader0044, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0044 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 3608
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "function __doPostBack(eventTarget, eventArgument) {");		// Test [44] <- Index 44
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [45] <- WEB ADMIN Index 60 ---
		proxyDataRecordId =1564999026300L;
		String requestProt0045 = "http";
		String requestHost0045 = "cldemo.apicasystem.com";
		int    requestPort0045 = 80;
		String requestFile0045 = "/ScriptResource.axd" +
				"?d=h56yi9f0SB7seER6Wx2QkrhPtSLbAbmjWfLbxe6NnMKLKb_x1EczU3yqrSvXnNDzCA31HvjHi1zMywd_i_iEEcgT5k2GGUisXfZMzAapkPayWJ9AxbjDAAGN2939G6RmvTumPfamqanP4KrFXzPHlSA3kqBCx7sCGYHewvdUTT0C-MtS0" +
				"&t=ca758f3";
		String requestHeader0045 = "GET " + requestFile0045 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0045, requestHost0045, requestPort0045, requestHeader0045, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0045 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 25604
		// content test algorithm: check size +/- 5%, defined content size = 25604
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 25604, 5);		// Test [45] <- Index 45
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [46] <- WEB ADMIN Index 61 ---
		proxyDataRecordId =1564999026301L;
		String requestProt0046 = "http";
		String requestHost0046 = "cldemo.apicasystem.com";
		int    requestPort0046 = 80;
		String requestFile0046 = "/Styles/stylesheet.css";
		String requestHeader0046 = "GET " + requestFile0046 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0046, requestHost0046, requestPort0046, requestHeader0046, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0046 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1996
		// content test algorithm: check size +/- 5%, defined content size = 1996
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 1996, 5);		// Test [46] <- Index 46
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [47] <- WEB ADMIN Index 62 ---
		proxyDataRecordId =1564999026305L;
		String requestProt0047 = "http";
		String requestHost0047 = "cldemo.apicasystem.com";
		int    requestPort0047 = 80;
		String requestFile0047 = "/Scripts/GoogleAnalytics.js";
		String requestHeader0047 = "GET " + requestFile0047 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0047, requestHost0047, requestPort0047, requestHeader0047, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0047 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 423
		// content test algorithm: check size +/- 5%, defined content size = 423
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 423, 5);		// Test [47] <- Index 47
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [48] <- WEB ADMIN Index 63 ---
		proxyDataRecordId =1564999026306L;
		String requestProt0048 = "http";
		String requestHost0048 = "cldemo.apicasystem.com";
		int    requestPort0048 = 80;
		String requestFile0048 = "/WebResource.axd" +
				"?d=SwCcMWJbC5HPR0GyMZBQBtBVcjnGUcMopW87tvl8Uit8R50NU80PEVSNB0QE3yO4B2yncMJIGpp_qLe8p71gNcCZXqg1" +
				"&t=635195493660000000";
		String requestHeader0048 = "GET " + requestFile0048 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0048, requestHost0048, requestPort0048, requestHeader0048, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0048 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5770
		// content test algorithm: check size +/- 5%, defined content size = 5770
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 5770, 5);		// Test [48] <- Index 48
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [49] <- WEB ADMIN Index 64 ---
		proxyDataRecordId =1564999026307L;
		String requestProt0049 = "http";
		String requestHost0049 = "cldemo.apicasystem.com";
		int    requestPort0049 = 80;
		String requestFile0049 = "/ScriptResource.axd" +
				"?d=pF1UDEgDL-2LZwQfO6oW8b5wup5ZTmRNHIIKGMEg7qKDcL2x4ExDoDjg0E8z3OvGe2w9EPoQYsum-y_KtzjGbPMaWSf7JE_TIeSMo4-aeyM5O68PbG2PnQA031vNZ3k7GOtQNGdd6urpXo2j_XbTbRcZAtwb36HBbokBnkQqexUHSfjE0" +
				"&t=ca758f3";
		String requestHeader0049 = "GET " + requestFile0049 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0049, requestHost0049, requestPort0049, requestHeader0049, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0049 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 9984
		// content test algorithm: check size +/- 5%, defined content size = 9984
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 9984, 5);		// Test [49] <- Index 49
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [50] <- WEB ADMIN Index 65 ---
		proxyDataRecordId =1564999026318L;
		String requestProt0050 = "http";
		String requestHost0050 = "cldemo.apicasystem.com";
		int    requestPort0050 = 80;
		String requestFile0050 = "/Images/Banners/WindowsAzure.jpg";
		String requestHeader0050 = "GET " + requestFile0050 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0050, requestHost0050, requestPort0050, requestHeader0050, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0050 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 1238
		// content test algorithm: check size +/- 5%, defined content size = 1238
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 1238, 5);		// Test [50] <- Index 50
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [51] <- WEB ADMIN Index 66 ---
		proxyDataRecordId =1564999026334L;
		String requestProt0051 = "http";
		String requestHost0051 = "cldemo.apicasystem.com";
		int    requestPort0051 = 80;
		String requestFile0051 = "/Images/Banners/Bullet.png";
		String requestHeader0051 = "GET " + requestFile0051 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0051, requestHost0051, requestPort0051, requestHeader0051, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0051 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 405
		// content test algorithm: check size +/- 5%, defined content size = 405
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 405, 5);		// Test [51] <- Index 51
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [52] <- WEB ADMIN Index 67 ---
		proxyDataRecordId =1564999026341L;
		String requestProt0052 = "http";
		String requestHost0052 = "cldemo.apicasystem.com";
		int    requestPort0052 = 80;
		String requestFile0052 = "/Images/cart.png";
		String requestHeader0052 = "GET " + requestFile0052 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0052, requestHost0052, requestPort0052, requestHeader0052, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0052 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 423
		// content test algorithm: check size +/- 5%, defined content size = 423
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 423, 5);		// Test [52] <- Index 52
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [53] <- WEB ADMIN Index 68 ---
		proxyDataRecordId =1564999026345L;
		String requestProt0053 = "http";
		String requestHost0053 = "cldemo.apicasystem.com";
		int    requestPort0053 = 80;
		String requestFile0053 = "/Images/logo.png";
		String requestHeader0053 = "GET " + requestFile0053 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0053, requestHost0053, requestPort0053, requestHeader0053, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0053 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 6391
		// content test algorithm: check size +/- 5%, defined content size = 6391
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 6391, 5);		// Test [53] <- Index 53
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [54] <- WEB ADMIN Index 69 ---
		proxyDataRecordId =1564999026349L;
		String requestProt0054 = "http";
		String requestHost0054 = "cldemo.apicasystem.com";
		int    requestPort0054 = 80;
		String requestFile0054 = "/Images/Banners/WindowsServer.jpg";
		String requestHeader0054 = "GET " + requestFile0054 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0054, requestHost0054, requestPort0054, requestHeader0054, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0054 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 1408
		// content test algorithm: check size +/- 5%, defined content size = 1408
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 1408, 5);		// Test [54] <- Index 54
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [55] <- WEB ADMIN Index 70 ---
		proxyDataRecordId =1564999026362L;
		String requestProt0055 = "http";
		String requestHost0055 = "cldemo.apicasystem.com";
		int    requestPort0055 = 80;
		String requestFile0055 = "/Images/Banners/Amazon.jpg";
		String requestHeader0055 = "GET " + requestFile0055 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0055, requestHost0055, requestPort0055, requestHeader0055, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0055 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 918
		// content test algorithm: check size +/- 5%, defined content size = 918
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 918, 5);		// Test [55] <- Index 55
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [56] <- WEB ADMIN Index 71 ---
		proxyDataRecordId =1564999026366L;
		String requestProt0056 = "http";
		String requestHost0056 = "cldemo.apicasystem.com";
		int    requestPort0056 = 80;
		String requestFile0056 = "/Images/Banners/Lamp.jpg";
		String requestHeader0056 = "GET " + requestFile0056 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0056, requestHost0056, requestPort0056, requestHeader0056, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0056 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 870
		// content test algorithm: check size +/- 5%, defined content size = 870
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 870, 5);		// Test [56] <- Index 56
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [57] <- WEB ADMIN Index 72 ---
		proxyDataRecordId =1564999026374L;
		String requestProt0057 = "http";
		String requestHost0057 = "cldemo.apicasystem.com";
		int    requestPort0057 = 80;
		String requestFile0057 = "/Images/img.jpg";
		String requestHeader0057 = "GET " + requestFile0057 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0057, requestHost0057, requestPort0057, requestHeader0057, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0057 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 46192
		// content test algorithm: check size +/- 5%, defined content size = 46192
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 46192, 5);		// Test [57] <- Index 57
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [58] <- WEB ADMIN Index 73 ---
		proxyDataRecordId =1564999026375L;
		String requestProt0058 = "http";
		String requestHost0058 = "cldemo.apicasystem.com";
		int    requestPort0058 = 80;
		String requestFile0058 = "/Images/ChLeagueFour.JPG";
		String requestHeader0058 = "GET " + requestFile0058 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0058, requestHost0058, requestPort0058, requestHeader0058, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0058 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 60220
		// content test algorithm: check size +/- 5%, defined content size = 60220
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 60220, 5);		// Test [58] <- Index 58
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [59] <- WEB ADMIN Index 74 ---
		proxyDataRecordId =1564999026376L;
		String requestProt0059 = "http";
		String requestHost0059 = "cldemo.apicasystem.com";
		int    requestPort0059 = 80;
		String requestFile0059 = "/Images/Logos/azure.png";
		String requestHeader0059 = "GET " + requestFile0059 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0059, requestHost0059, requestPort0059, requestHeader0059, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0059 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 4964
		// content test algorithm: check size +/- 5%, defined content size = 4964
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 4964, 5);		// Test [59] <- Index 59
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [60] <- WEB ADMIN Index 75 ---
		proxyDataRecordId =1564999026402L;
		String requestProt0060 = "http";
		String requestHost0060 = "cldemo.apicasystem.com";
		int    requestPort0060 = 80;
		String requestFile0060 = "/images/bg.jpg";
		String requestHeader0060 = "GET " + requestFile0060 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0060, requestHost0060, requestPort0060, requestHeader0060, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0060 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 130542
		// content test algorithm: check size +/- 5%, defined content size = 130542
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 130542, 5);		// Test [60] <- Index 60
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #1_2 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1_3.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #1 (fragment 4 of 4)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [61] <- WEB ADMIN Index 76 ---
		proxyDataRecordId =1564999026524L;
		String requestProt0061 = "http";
		String requestHost0061 = "cldemo.apicasystem.com";
		int    requestPort0061 = 80;
		String requestFile0061 = "/favicon.ico";
		String requestHeader0061 = "GET " + requestFile0061 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0061, requestHost0061, requestPort0061, requestHeader0061, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0061 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/X-ICON", header text fragment = [verification disabled], recorded content size = 1150
		// content test algorithm: check size +/- 5%, defined content size = 1150
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/X-ICON", null, 1150, 5);		// Test [61] <- Index 61
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [62] <- WEB ADMIN Index 77 ---
		proxyDataRecordId =1564999026527L;
		String requestProt0062 = "http";
		String requestHost0062 = "cldemo.apicasystem.com";
		int    requestPort0062 = 80;
		String requestFile0062 = "/font/myriadpro-regular_4-webfont.ttf";
		String requestHeader0062 = "GET " + requestFile0062 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0062, requestHost0062, requestPort0062, requestHeader0062, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0062 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 49392
		// content test algorithm: check size +/- 5%, defined content size = 49392
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/OCTET-STREAM", null, 49392, 5);		// Test [62] <- Index 62
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [63] <- WEB ADMIN Index 78 ---
		proxyDataRecordId =1564999026537L;
		String requestProt0063 = "http";
		String requestHost0063 = "cldemo.apicasystem.com";
		int    requestPort0063 = 80;
		String requestFile0063 = "/images/footer_right.png";
		String requestHeader0063 = "GET " + requestFile0063 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0063, requestHost0063, requestPort0063, requestHeader0063, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0063 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 427
		// content test algorithm: check size +/- 5%, defined content size = 427
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 427, 5);		// Test [63] <- Index 63
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [64] <- WEB ADMIN Index 79 ---
		proxyDataRecordId =1564999026541L;
		String requestProt0064 = "http";
		String requestHost0064 = "cldemo.apicasystem.com";
		int    requestPort0064 = 80;
		String requestFile0064 = "/images/navleft_h.png";
		String requestHeader0064 = "GET " + requestFile0064 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0064, requestHost0064, requestPort0064, requestHeader0064, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0064 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 254
		// content test algorithm: check size +/- 5%, defined content size = 254
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 254, 5);		// Test [64] <- Index 64
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [65] <- WEB ADMIN Index 80 ---
		proxyDataRecordId =1564999026542L;
		String requestProt0065 = "http";
		String requestHost0065 = "cldemo.apicasystem.com";
		int    requestPort0065 = 80;
		String requestFile0065 = "/images/navright_h.png";
		String requestHeader0065 = "GET " + requestFile0065 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0065, requestHost0065, requestPort0065, requestHeader0065, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0065 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 183
		// content test algorithm: check size +/- 5%, defined content size = 183
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 183, 5);		// Test [65] <- Index 65
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [66] <- WEB ADMIN Index 81 ---
		proxyDataRecordId =1564999026544L;
		String requestProt0066 = "http";
		String requestHost0066 = "cldemo.apicasystem.com";
		int    requestPort0066 = 80;
		String requestFile0066 = "/images/navleft.png";
		String requestHeader0066 = "GET " + requestFile0066 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0066, requestHost0066, requestPort0066, requestHeader0066, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0066 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 271
		// content test algorithm: check size +/- 5%, defined content size = 271
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 271, 5);		// Test [66] <- Index 66
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [67] <- WEB ADMIN Index 82 ---
		proxyDataRecordId =1564999026545L;
		String requestProt0067 = "http";
		String requestHost0067 = "cldemo.apicasystem.com";
		int    requestPort0067 = 80;
		String requestFile0067 = "/images/navright.png";
		String requestHeader0067 = "GET " + requestFile0067 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0067, requestHost0067, requestPort0067, requestHeader0067, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0067 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 192
		// content test algorithm: check size +/- 5%, defined content size = 192
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 192, 5);		// Test [67] <- Index 67
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [68] <- WEB ADMIN Index 83 ---
		proxyDataRecordId =1564999026565L;
		String requestProt0068 = "http";
		String requestHost0068 = "cldemo.apicasystem.com";
		int    requestPort0068 = 80;
		String requestFile0068 = "/images/headbg.png";
		String requestHeader0068 = "GET " + requestFile0068 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0068, requestHost0068, requestPort0068, requestHeader0068, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0068 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 234
		// content test algorithm: check size +/- 5%, defined content size = 234
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 234, 5);		// Test [68] <- Index 68
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [69] <- WEB ADMIN Index 84 ---
		proxyDataRecordId =1564999026567L;
		String requestProt0069 = "http";
		String requestHost0069 = "cldemo.apicasystem.com";
		int    requestPort0069 = 80;
		String requestFile0069 = "/images/header_right.png";
		String requestHeader0069 = "GET " + requestFile0069 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0069, requestHost0069, requestPort0069, requestHeader0069, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0069 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 272
		// content test algorithm: check size +/- 5%, defined content size = 272
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 272, 5);		// Test [69] <- Index 69
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [70] <- WEB ADMIN Index 85 ---
		proxyDataRecordId =1564999026569L;
		String requestProt0070 = "http";
		String requestHost0070 = "cldemo.apicasystem.com";
		int    requestPort0070 = 80;
		String requestFile0070 = "/images/right_banner.jpg";
		String requestHeader0070 = "GET " + requestFile0070 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0070, requestHost0070, requestPort0070, requestHeader0070, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0070 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 8180
		// content test algorithm: check size +/- 5%, defined content size = 8180
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 8180, 5);		// Test [70] <- Index 70
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [71] <- WEB ADMIN Index 86 ---
		proxyDataRecordId =1564999026570L;
		String requestProt0071 = "http";
		String requestHost0071 = "cldemo.apicasystem.com";
		int    requestPort0071 = 80;
		String requestFile0071 = "/Images/white_banner_900x25.png";
		String requestHeader0071 = "GET " + requestFile0071 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0071, requestHost0071, requestPort0071, requestHeader0071, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0071 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1446
		// content test algorithm: check size +/- 5%, defined content size = 1446
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1446, 5);		// Test [71] <- Index 71
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [72] <- WEB ADMIN Index 87 ---
		proxyDataRecordId =1564999026571L;
		String requestProt0072 = "http";
		String requestHost0072 = "cldemo.apicasystem.com";
		int    requestPort0072 = 80;
		String requestFile0072 = "/images/header_left.png";
		String requestHeader0072 = "GET " + requestFile0072 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0072, requestHost0072, requestPort0072, requestHeader0072, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0072 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 346
		// content test algorithm: check size +/- 5%, defined content size = 346
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 346, 5);		// Test [72] <- Index 72
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [73] <- WEB ADMIN Index 88 ---
		proxyDataRecordId =1564999026575L;
		String requestProt0073 = "http";
		String requestHost0073 = "cldemo.apicasystem.com";
		int    requestPort0073 = 80;
		String requestFile0073 = "/images/footer_left.png";
		String requestHeader0073 = "GET " + requestFile0073 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0073, requestHost0073, requestPort0073, requestHeader0073, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0073 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 445
		// content test algorithm: check size +/- 5%, defined content size = 445
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 445, 5);		// Test [73] <- Index 73
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [74] <- WEB ADMIN Index 89 ---
		proxyDataRecordId =1564999026603L;
		String requestProt0074 = "http";
		String requestHost0074 = "cldemo.apicasystem.com";
		int    requestPort0074 = 80;
		String requestFile0074 = "/images/footer_mid.png";
		String requestHeader0074 = "GET " + requestFile0074 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0074, requestHost0074, requestPort0074, requestHeader0074, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0074 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 212
		// content test algorithm: check size +/- 5%, defined content size = 212
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 212, 5);		// Test [74] <- Index 74
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [75] <- WEB ADMIN Index 90 ---
		proxyDataRecordId =1564999026604L;
		String requestProt0075 = "http";
		String requestHost0075 = "cldemo.apicasystem.com";
		int    requestPort0075 = 80;
		String requestFile0075 = "/font/myriadpro-semibold_6-webfont.ttf";
		String requestHeader0075 = "GET " + requestFile0075 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"DNT: 1\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0075, requestHost0075, requestPort0075, requestHeader0075, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else
			{
				performanceData = testURL.getPerformanceData();
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		if(replayMode)
		{
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		requestHeader0075 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 48268
		// content test algorithm: check size +/- 5%, defined content size = 48268
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/OCTET-STREAM", null, 48268, 5);		// Test [75] <- Index 75
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #1_3 successful done
		return true;
	}



	boolean synchResponsesParallelRequestsPage_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 1 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_1(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_1 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	/**
	 * implement GetRealTimeUserInputFieldsInterface: get the definition and the value of all real-time user input fields.
	 */
	public ArrayList<RealTimeUserInputField> getRealTimeUserInputFields()
	{
		try
		{
			ArrayList<RealTimeUserInputField> realTimeUserInputFieldList = new ArrayList<RealTimeUserInputField>();
			return realTimeUserInputFieldList;
		}
		catch (Exception e)
		{
			log(e);
			return null;
		}
	}



	/**
	 * implement ThreadStepInterface: get the current execution step (current URL call or page break) of a simulated user.
	 */
	public int getExecutionStep()
	{
		return threadStep;
	}



	/**
	 * implement SetThreadStepInterface: set the current execution step (current URL call or page break) of a simulated user.
	 */
	public void setExecutionStep(int threadStep)
	{
		this.threadStep = threadStep;
	}



	/**
	 * implement SSLSessionCacheStatisticInterface: get statistic data about the SSL session cache behavior of a simulated user.
	 */
	public SSLSessionCacheStatistic getSSLSessionCacheStatistic()
	{
		return sslStatistic;
	}



	/**
	 * implement VaryingTestDurationInterface: support to extend or to reduce the planned test duration.
	 */
	public int getPlannedTestDuration()
	{
		return plannedTestDuration;
	}
	
	public void setExtendTestDuration(int deltaSeconds)
	{
		if (plannedTestDuration == 0)
		{
			plannedTestDuration = deltaSeconds;		// the old planned test duration was unlimited but is now limited
			return;
		}
		if (deltaSeconds == 0)
		{
			plannedTestDuration = 0;		// the new planned test duration is now unlimited
			return;
		}
		plannedTestDuration = plannedTestDuration + deltaSeconds;
	}



	/**
	 * implement SuspendResumeInterface: support to suspend and to resume the test execution.
	 */
	public int getPlannedStartupDelay()
	{
		return plannedStartupDelay;
	}
	
	public void setUserResumeStartWaitDelay(int millis)
	{
		userResumeStartWaitDelay = millis;
	}



	/**
	 * implement VaryingLoadInterface: support to decrement the number of simulated users at runtime.
	 */
	public void setDecrementEndOfLoopFlag(boolean decrementEndOfLoopFlag)
	{
		this.decrementEndOfLoopFlag = decrementEndOfLoopFlag;
	}

	public boolean isDecrementEndOfLoopFlag()
	{
		return decrementEndOfLoopFlag;
	}



	/**
	 * internal method: execute the loops for one simulated user as a thread.
	 * controls the thread and displays the (thread-)log if one loop has been completed.
	 */
	public void run()
	{
		// user terminated by inline script, at start of user ?
		if (isTerminateUser())
		{
			System.out.println("# --- thread " + Thread.currentThread().getName() + " aborted --- " + ZoneTime.dateToShortString() + " ---");
			return;
		}
		try
		{
			while (true)
			{
				threadStep = ThreadStepInterface.THREAD_NO_STEP;
				clearLog();
				
				// execute loop
				log("--- loop started --- " + ZoneTime.dateToShortString() + " ---");
				loopStartTime = System.nanoTime();
				if(replayMode)
				{
					createReplaySnapShot(threadLoopCounter, replaySnapShotsDump);
				}
				boolean loopPassed = this.execute(totalLoopCounter.getAndIncrement());
				performanceData.addUserTransactionMeasuredSamples(transactionHandler.getPendingTransactions());
				ArrayList<UserTransactionContext> nonExecutedTransactions = transactionHandler.getNotExecutedTransactions();

				for (UserTransactionContext nonExecutedTransaction : new ArrayList<>(nonExecutedTransactions))
				{
					if(transactionContextMap.containsKey(nonExecutedTransaction.getTransactionId()+"") && transactionContextMap.get(nonExecutedTransaction.getTransactionId()+"") == null)
					{
						transactionContextMap.remove(nonExecutedTransaction.getTransactionId()+"");
						nonExecutedTransactions.remove(nonExecutedTransaction);
					}
				}

				performanceData.addUserTransactionNotExecutedSamples(nonExecutedTransactions);
				performanceData.addSocktPoolStatistic(socketPool);
				socketPool.closePool();
				performanceData.addSSLCacheStatistic(sslStatistic.getSSLSessionCacheStatisticResult());
				sslStatistic.reset();
				
				// eof of input file ?
				if (abortedByEofInputFile())
					return;		// endOfRun() not called in such a case
				
				// check loop result
				String remainingLoopInfo = "";
				if (checkLoopCount)
					remainingLoopInfo = " [remaining loops = " + (remainingLoops - 1) + "]";
				if (loopPassed)
				{
					performanceData.addPassedLoop();
					log("--- loop passed ---  " + ZoneTime.dateToShortString() + " ---" + remainingLoopInfo);
				}
				else
				{
					performanceData.addFailedLoop();
					log("--- loop failed ---  " + ZoneTime.dateToShortString() + " ---" + remainingLoopInfo);
				}
				threadStep = ThreadStepInterface.THREAD_NO_STEP;
				
				// display thread log to standard output
				if (debugLoops || (debugFailedLoops && (!loopPassed)))
				{
					synchronized (dumpLock)
					{
						dumpLog(System.out);				// full log
					}
				}
				
				// check if max loops reached
				if (checkLoopCount)
				{
					// all done ?
					remainingLoops--;
					if (remainingLoops <= 0)
					{
						endOfRun();
						return;
					}
				}
				
				// check if simulated user must be decremented
				if (decrementEndOfLoopFlag && (getOwnLoadTestUserContext().getDecrementEndOfLoopPointInTime() <= System.currentTimeMillis()))
				{
					return;
				}
				
				// check if max test duration reached
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				{
					endOfRun();
					return;
				}
				
				// check if this specific user is terminated earlier than planned by a HTTP content verification or by a plug-in
				if (isTerminateUser())
				{
					endOfRun();
					System.out.println("# --- thread " + Thread.currentThread().getName() + " terminate failed user --- " + ZoneTime.dateToShortString() + " ---");
					return;
				}
				
				// check if load test execution is temporary suspended
				boolean wasSuspended = false;
				while (isSuspend())
				{
					wasSuspended = true;
					try { Thread.currentThread().sleep(20); } catch (InterruptedException ie) {}
					if (abortedByRemote() || abortedByEofInputFile())
					{
						endOfRun();
						return;
					}
					
					// check if max test duration reached during suspend
					if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
					{
						endOfRun();
						return;
					}
				}
				// check if load test execution is resumed
				if (wasSuspended)
				{
					try { sleepRemoteInterruptable(userResumeStartWaitDelay); } catch (InterruptedException ie) {}
				}
				
				// wait 20 milliseconds if loop has failed
				if (!loopPassed)
					try { Thread.currentThread().sleep(loopErrorDelay); } catch (InterruptedException ie) {}
				
				// pacing for the loop
				if(pacing > 0)
				{
					long loopElaspedTime = System.nanoTime() - loopStartTime;
					long loopPacingValue = Long.valueOf(pacing).longValue() * 1000000l;
					if (loopElaspedTime < loopPacingValue)
					{
						threadStep = threadStep - 1;
						log(" - loop pacing: sleeping for"+ (loopPacingValue - loopElaspedTime)/ 1000+" ms ...");
						Thread.currentThread().sleep(loopPacingValue - loopElaspedTime);
						threadStep++;
					}
				}
				// execute next loop
				threadLoopCounter++;
			}	// end: while (true)
		}
		catch (Throwable tex)
		{
			log("*** INTERNAL ERROR / LOAD TEST ABORTED ***");
			log(tex);
			log();
			synchronized (dumpLock)
			{
				dumpLog(System.out);				// full log
				System.err.println("*** INTERNAL ERROR / LOAD TEST ABORTED ***");
				tex.printStackTrace(System.err);
				System.exit(-2);
			}
		}
		finally
		{
			// remove the reference to this load test instance and the reference to the thread that runs this instance
			try
			{
				if (!decrementEndOfLoopFlag)
				{
					getUserContextTable().getWriteLock().lock();
					getOwnLoadTestUserContext().setLoadTestUserFinallyEnded();
					getUserContextTable().getWriteLock().unlock();
				}
				else
					decrementEndOfLoopFlag = false;
			}
			catch (Throwable texFinal)
			{
				System.err.println("*** INTERNAL FINALLY ERROR / LOAD TEST ABORTED ***");
				texFinal.printStackTrace(System.err);
				System.exit(-2);
			}
		}
	}



	/**
	 * internal method: called when a user has completed the test-run.
	 */
	public void endOfRun()
	{
		clearLog();
		
		if (debugLoops && (getLog().size() > 0))
		{
			synchronized (dumpLock)
			{
				dumpLog(System.out);		// dump log of inline scripts and load test plug-ins which are executed at end of user
			}
		}
	}



	/**
	 * Main program. Starts the test and waits until all have been done.
	 */
	public static void main(String[] args)
	{
		// check command line argument -h or -help
		if ((ParseArgs.hasOption(args, "-h")) || (ParseArgs.hasOption(args, "-help")))
		{
			System.out.println();
			System.out.println("Help - Proxy Sniffer Load Test Program:");
			System.out.println();
			System.out.println("-u <number>              ->> required argument: number of concurrent users");
			System.out.println("-d <seconds>             ->> required argument: planned test duration in seconds (default: 30, 0 = unlimited)");
			System.out.println("-t <seconds>             ->> required argument: request timeout per url in seconds");
			System.out.println();
			System.out.println("-tconnect <seconds>      ->> TCP/IP socket connect timeout in seconds (default: use value of -t <seconds>)");
			System.out.println();
			System.out.println("-sdelay <milliseconds>   ->> startup delay time between concurrent users in milliseconds (default: 200)");
			System.out.println("-mtpu <number>           ->> maximum number of parallel threads per user (default: " + MAX_PARALLEL_THREADS_PER_USER + ")");
			System.out.println("-maxloops <number>       ->> maximum number of loops per user (default: 0 = unlimited)");
			System.out.println("-pacing <seconds>        ->> sets a minimum time for all in the loop executed page breaks and url calls which must be elapsed before the next loop starts (default: 0 = no pacing)");
			System.out.println("-downlink <kbps>         ->> maximum downlink network bandwidth per user in kilobits per second (default: 0 = unlimited)");
			System.out.println("-uplink <kbps>           ->> maximum uplink network bandwidth per user in kilobits per second (default: 0 = unlimited)");
			System.out.println("-multihomed <filename>   ->> use serveral client ip addresses - file format: <addr1>, <addr2>, ... (all on the same line)");
			System.out.println("-sampling <seconds>      ->> statistic sampling interval in seconds (default: 15)");
			System.out.println("-percpage <percent>      ->> additional sampling rate per web page call in percent (default: 100)");
			System.out.println("-percurl <percent>       ->> additional sampling rate per url call in percent (default: 0)");
			System.out.println("-percurlopt <level>      ->> extended sampling level per url call, see application reference manual (default: 0 = disabled)");
			System.out.println("-maxerrsnap <number>     ->> maximum number of error snapshots per url (default: 0 = unlimited)");
			System.out.println("-maxerrmem <megabytes>   ->> maximum size of memory in megabytes which can be used for error snapshots (default: 20, -1 = unlimited)");
			System.out.println("-nosdelayCluster         ->> apply startup delay time between concurrent users per exec agent, but not per cluster job (default: apply per cluster job)");
			System.out.println("-setuseragent \"<text>\"   ->> replace the recorded value of the HTTP request header field User-Agent with a new value");
			System.out.println("-collect <host>[:<port>] ->> collect additional data from external measuring agents (data collectors)");
			System.out.println("-res <filename>          ->> overrides the default name of the binary output file");
			System.out.println("-nores                   ->> disables to create the binary output file");
			System.out.println();
			System.out.println("-ssl <version>           ->> set SSL version: possible options are \"all\" (default), \"v3\", \"tls\", \"tls11\" or \"tls12\"");
			System.out.println("-sslcache <seconds>      ->> timeout of user-related SSL session cache (default: 300, 0 = cache disabled)");
			System.out.println("-sslrandom <type>        ->> set the type of the random generator used for SSL handshakes: possible options are \"fast\", \"iaik\" (default) or \"java\"");
			System.out.println("-sslcmode                ->> apply SSL/HTTPS compatibility workarounds for deficient SSL servers");
			System.out.println("-ecc                     ->> enable support of elliptic curve cryptography (ECC)");
			System.out.println("-nosni                   ->> disable support of server name indication (SNI)");
			System.out.println("-snicritical             ->> set the TLS SNI extension as critical (default: non-critical)");
			System.out.println("-tlssessiontickets       ->> set the TLS to use Session Tickets (non-critical)");
			System.out.println("-iaikLast                ->> adds the IAIK security provider at the last position (instead of default: IAIK at first position)");
			System.out.println();
			System.out.println("-dnssrv <IP-1>[,IP-N])   ->> use specific DNS server(s) to resolve DNS host names (default: use OS to resolve host names)");
			System.out.println("-dnshosts <filename>     ->> use specific DNS hosts file (default: use OS to resolve host names)");
			System.out.println("-dnstranslation <filename> ->> use a DNS translation file that converts DNS names. It might be needed to disable TLS SNI if this option is used");
			System.out.println("-dnsenattl               ->> enable consideration of DNS TTL by using the received TTL-values from the DNS Server(s) (default: TTL disabled)");
			System.out.println("-dnsfixttl <seconds>     ->> enable DNS TTL by using a fixed TTL-value of seconds for all DNS resolves");
			System.out.println("-dnsperloop              ->> perform new DNS resolves for each executed loop. All resolves are stable within the same loop (no consideration of DNS TTL within a loop)");
			System.out.println("-dnsstatistic            ->> collect statistical data about DNS resolutions. Note: use this option only if not any other, more specific DNS option is enabled");
			System.out.println("-dnsdebug                ->> debug DNS resolves and the DNS cache");
			System.out.println("-enableIPv6 <networkinterface-name>  ->> enable only IPv6 support for recording, also can provide the IPv6 network interface of the load generator");
			System.out.println("-enableIPv6v4 <networkinterface-name> ->> enable both IPv6 and IPv4 (first will try with IPv6 ,if fails will try with IPv4 support for recording),also can provide the IPv6 network interface of the load generator");
			System.out.println();
			System.out.println("-dfl                     ->> debug execution steps of all failed loops to standard output");
			System.out.println("-dl                      ->> debug execution steps of all loops to standard output");
			System.out.println("-dh                      ->> debug HTTP protocol headers to standard output, includes the -dl option");
			System.out.println("-dc                      ->> debug HTTP content data to standard output, includes the -dl option");
			System.out.println("-dhc                     ->> debug HTTP protocol headers and HTTP content data to standard output, includes the -dl option");
			System.out.println("-dC                      ->> debug cookies to standard output, includes the -dl option");
			System.out.println("-dK                      ->> debug keep-alive (socket pool) to standard output, includes the -dl option");
			System.out.println("-dssl                    ->> debug SSL handshake (https) to standard output, includes the -dl and the -dK option");
			System.out.println();
			System.out.println("-tz <timezone>           ->> set time zone (see Application Reference Manual: supported time zones)");
			System.out.println("-dgs a|c                 ->> set number format (decimal group separator) a = '  c = ,");
			System.out.println("-browserlang <text>      ->> set the browser language for the test");
			System.out.println("-enablebrowcache         ->> set the browser cache mode on");
			System.out.println("-replay                  ->> Indicates the replay mode");
			System.out.println("-annotation <text>       ->> adds an annotation for this test run");
			System.out.println();
			System.out.println("-execAgentHost <ip address or dns name>      ->> set the ip address or the dns name of the exec agent from which the license is used (default: 127.0.0.1)");
			System.out.println("-execAgentPort <port>                        ->> set the tcp/ip port of the exec agent (default: 7993)");
			System.out.println("-execAgentProtocol <plain | http | https>    ->> set the protocol of the exec agent (default: plain)");
			System.out.println("-execAgentUsername <string>                  ->> set the auth. username for the exec agent (default: [no username])");
			System.out.println("-execAgentPassword <string>                  ->> set the auth. password for the exec agent (default: [no password])");
			System.out.println();
			System.out.println("-h                       ->> display this help text");
			System.out.println("-help                    ->> display this help text");
			System.out.println();
			System.exit(-1);
		}
		
		System.out.println("+----------------------------------------------------------------+");
		System.out.println("| Welcome to the ZebraTester Load Test Program.                  |");
		System.out.println("| Additional help available with program argument \"-help\"        |");
		System.out.println("| Procedure Copyright by Ingenieurbuero David Fischer AG,        |");
		System.out.println("| a company of the Apica group. All rights reserved.             |");
		System.out.println("+----------------------------------------------------------------+");
		
		
		if (commonNextProxyConfig != null)
		{
			System.out.println();
			System.out.println("*** Warning: Loadtest over HTTP(S) Proxy ***");
		}
		
		// check command line argument -ecc
		sslECC = (ParseArgs.hasOption(args, "-ecc"));       // enable ssl ecc ?
		
		// initialize ssl/https support
		SSLInit.execute(!ParseArgs.hasOption(args, "-iaikLast"), true);
		if (sslECC)
			SSLInit.enableECC();
		
		// check command line argument -nosni
		if (ParseArgs.hasOption(args, "-nosni"))            // disable ssl sni ?
			sslSNI = false;
		
		// check command line argument -snicritical
		if (ParseArgs.hasOption(args, "-snicritical"))      // set ssl sni as critical tls extension ?
			sslSNICirical = true;
		
		// check command line argument -tlssessiontickets
		if (ParseArgs.hasOption(args, "-tlssessiontickets"))      // set tls extension session tickets?
			useTlsSessionTickets = true;
		
		// set default character set for response content tests
		setCharEncoding(prxCharEncoding);
		
		// check command line argument -tz <timezone>
		String timeZoneString = ParseArgs.getString(args, "-tz");
		if (timeZoneString != null)
			defaultTimeZone = timeZoneString.toUpperCase(); // set time zone?
		ZoneTime.setDefaultTimeZone(defaultTimeZone);
		
		// check command line argument -dgs a|c
		String dgs = ParseArgs.getString(args, "-dgs");
		if (dgs != null)
		{
			if (dgs.equalsIgnoreCase("a"))
				defaultNumberGroupingSeparator = '\'';
			if (dgs.equalsIgnoreCase("c"))
				defaultNumberGroupingSeparator = ',';
		}
		Lib.setDefaultNumberGroupingSeparator(defaultNumberGroupingSeparator);
		
		// check command line argument -browserlang <text>
		browserLanguage = ParseArgs.getString(args, "-browserlang");
		
		// check command line argument -enablebrowcache
		if (ParseArgs.hasOption(args, "-enablebrowcache"))
		{
			enableBrowserCache = true;
		}
		
		// check command line argument -replay
		if (ParseArgs.hasOption(args, "-replay"))
		{
			replayMode = true;
		}
		
		// check command line argument -annotation <text>
		String testRunAnnotation = ParseArgs.getString(args, "-annotation");
		if (testRunAnnotation != null)
		{
			if (testRunAnnotation.startsWith("\"") && testRunAnnotation.endsWith("\""))
				testRunAnnotation = testRunAnnotation.substring(1, testRunAnnotation.length() - 1);
		}
		
		// check command line argument -ssl
		String newSslProtocolVersion = ParseArgs.getString(args, "-ssl");
		if (newSslProtocolVersion != null)
		{
			if (newSslProtocolVersion.equalsIgnoreCase("v2"))
				sslProtocolVersion = "v2";
			if (newSslProtocolVersion.equalsIgnoreCase("v3"))
				sslProtocolVersion = "v3";
			if (newSslProtocolVersion.equalsIgnoreCase("tls"))
				sslProtocolVersion = "tls";
			if (newSslProtocolVersion.equalsIgnoreCase("tls11"))
				sslProtocolVersion = "tls11";
			if (newSslProtocolVersion.equalsIgnoreCase("tls12"))
				sslProtocolVersion = "tls12";
		}
		
		// check command line argument -sslcache <seconds>
		Integer newSslSessionCacheTimeout = ParseArgs.getInteger(args, "-sslcache");
		if (newSslSessionCacheTimeout != null)
			sslSessionCacheTimeout = newSslSessionCacheTimeout.intValue();
		
		// check command line argument -sslrandom
		String sslHandshakeRandomGeneratorTypeStr = ParseArgs.getString(args, "-sslrandom");
		if (sslHandshakeRandomGeneratorTypeStr != null)
		{
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("java"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_JAVA_DEFAULT;
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("iaik"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_IAIK_DEFAULT;
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("fast"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_FAST;
		}
		
		// check command line argument -sslcmode
		sslcmode = ParseArgs.hasOption(args, "-sslcmode");  // enable ssl/https compatibility workarounds?
		
		// check command line argument -dfl
		debugFailedLoops = ParseArgs.hasOption(args, "-dfl"); // debug failed loops?
		
		// check command line argument -dl
		debugLoops = ParseArgs.hasOption(args, "-dl");      // debug loops?
		
		// check command line argument -dh
		debugHttp = ParseArgs.hasOption(args, "-dh");       // debug http?
		if (debugHttp)
			debugLoops = true;
		
		// check command line argument -dc
		debugContent = ParseArgs.hasOption(args, "-dc");    // debug content?
		if (debugContent)
			debugLoops = true;
		
		// check command line argument -dhc
		if (ParseArgs.hasOption(args, "-dhc"))				// debug http and content
		{
			debugLoops = true;
			debugHttp = true;
			debugContent = true;
		}
		
		// check command line argument -dC
		debugCookies = ParseArgs.hasOption(args, "-dC");    // debug cookies?
		if (debugCookies)
			debugLoops = true;
		
		// check command line argument -dK
		debugKeepAlive = ParseArgs.hasOption(args, "-dK");  // debug keep.alive (socket pool)?
		if (debugKeepAlive)
			debugLoops = true;
		
		// check command line argument -dssl
		debugSsl = ParseArgs.hasOption(args, "-dssl");      // debug keep.alive (socket pool)?
		if (debugSsl)
		{
			debugLoops = true;
			debugKeepAlive = true;
		}
		
		// get startup delay
		Integer newStartupDelay = ParseArgs.getInteger(args, "-sdelay");
		if (newStartupDelay != null)
			plannedStartupDelay = newStartupDelay.intValue();
		
		// get max. parallel threads per user - note: only valid if CONTAINS_PARALLEL_EXECUTED_URLS = true
		Integer newMaxParallelThreadsPerUser = ParseArgs.getInteger(args, "-mtpu");
		if (newMaxParallelThreadsPerUser != null)
		{
			if (newMaxParallelThreadsPerUser.intValue() > 0)
				maxParallelThreadsPerUser = newMaxParallelThreadsPerUser.intValue();
		}
		// get maximum number of loops per user
		maxPlannedLoops = 0;  // maximum loops per user, 0 = unlimited
		Integer newLoops = ParseArgs.getInteger(args, "-maxloops");
		if (newLoops != null)
			maxPlannedLoops = newLoops.intValue();
		
		// pacing of loops per user
		pacing = 0;  // pacing of loops per user, 0 = unlimited
		Integer pacing = ParseArgs.getInteger(args, "-pacing");
		if (pacing != null)
			pacing = pacing.intValue();
		
		// get maximum downlink network bandwidth per user (default = unlimited)
		Integer newDownlinkBandwidth = ParseArgs.getInteger(args, "-downlink");
		if (newDownlinkBandwidth != null)
			downlinkBandwidth = newDownlinkBandwidth.intValue();
		
		// get maximum uplink network bandwidth per user (default = unlimited)
		Integer newUplinkBandwidth = ParseArgs.getInteger(args, "-uplink");
		if (newUplinkBandwidth != null)
			uplinkBandwidth = newUplinkBandwidth.intValue();
		
		// get statistic sampling interval
		int samplingInterval = 15;  // statistic sampling interval in seconds
		Integer newSamplingInterval = ParseArgs.getInteger(args, "-sampling");
		if (newSamplingInterval != null)
			samplingInterval = newSamplingInterval.intValue();
		
		// get additional sampling rate per web page call
		int percentilePageSampling = 100;  // additional sampling rate per web page call in percent
		Integer newPercentilePageSampling = ParseArgs.getInteger(args, "-percpage");
		if (newPercentilePageSampling != null)
			percentilePageSampling = newPercentilePageSampling.intValue();
		
		// get additional sampling rate per url call
		int percentileUrlSampling = 0;  // additional sampling rate per url call in percent
		Integer newPercentileUrlSampling = ParseArgs.getInteger(args, "-percurl");
		if (newPercentileUrlSampling != null)
			percentileUrlSampling = newPercentileUrlSampling.intValue();
		
		// get extended sampling level per url call
		int percentileUrlSamplingAddOption = 0;  // extended sampling level per url call, 0 = disabled
		Integer newPercentileUrlSamplingAddOption = ParseArgs.getInteger(args, "-percurlopt");
		if (newPercentileUrlSamplingAddOption != null)
			percentileUrlSamplingAddOption = newPercentileUrlSamplingAddOption.intValue();
		
		// get maximum number of error snapshots per URL (0 = unlimited)
		int maxErrorSnapshots = 0;
		Integer newMaxErrorSnapshots = ParseArgs.getInteger(args, "-maxerrsnap");
		if (newMaxErrorSnapshots != null)
			maxErrorSnapshots = newMaxErrorSnapshots.intValue();
		
		// get maximum memory in megabytes which can be used for error snapshots (-1 = unlimited, default = 10)
		long maxErrorSnapshotMemory = 20;
		Long newMaxErrorSnapshotMemory = ParseArgs.getLong(args, "-maxerrmem");
		if (newMaxErrorSnapshotMemory != null)
			maxErrorSnapshotMemory = newMaxErrorSnapshotMemory.longValue();
		
		// single user mode ?
		boolean singleUserMode = ParseArgs.hasOption(args, "-singleuser");
		
		// override value for http user agent field ?
		String setUserAgentStr = ParseArgs.getIgnoreCaseString(args, "-setuseragent");
		if (setUserAgentStr != null)
		{
			USER_AGENT_1 = setUserAgentStr;
		}
		// get required input arguments
		int concurrentUsers = 0;     // number of concurrent users
		plannedRequestTimeout = 0;   // request timeout in seconds
		
		System.out.println();
		
		// parse -u argument or ask --> <number of concurrent users>
		Integer i = ParseArgs.getIntegerOrAsk(args, "-u", "Concurrent Users, <RETURN>=1 : ", new Integer(1));
		if (i == null)
			System.exit(-1);
		else
			concurrentUsers = i.intValue();
		
		// parse -d argument or ask --> <test duration in seconds>
		i = ParseArgs.getIntegerOrAsk(args, "-d", "Test Duration in Seconds, <RETURN>=30 : ", new Integer(30));
		if (i == null)
			System.exit(-1);
		else
			plannedTestDuration = i.intValue();
		
		// parse -t argument or ask --> <request timeout in seconds>
		i = ParseArgs.getIntegerOrAsk(args, "-t", "HTTP Request Timeout per URL in Seconds, <RETURN>=60 : ", new Integer(60));
		if (i == null)
			System.exit(-1);
		else
			plannedRequestTimeout = i.intValue();
		
		// parse optional -tconnect argument (TCP/IP socket connect timeout in seconds)
		i = ParseArgs.getInteger(args, "-tconnect");
		if (i != null)
			plannedConnectTimeout = i.intValue();
		
		String genericFileName = PerformanceData.proposeFileName("cldemotesting", concurrentUsers, ParseArgs.getString(args, "-executionPlan"));
		
		// auto-configure binary result file
		if (!ParseArgs.hasOption(args, "-nores"))
		{
			String newResultFile = ParseArgs.getString(args, "-res");
			if (newResultFile == null)
				resultFile = genericFileName + ".prxres";
			else
				resultFile = newResultFile;
			System.out.println("Result File : " + resultFile);
		}
		
		// display common arguments at console output
		System.out.println();
		System.out.println("# concurrent users = " + concurrentUsers);
		System.out.println("# max. parallel threads per user = [serial execution order for all URLs]");
		System.out.print("# planned test duration = ");
		if (plannedTestDuration == 0)
			System.out.println("unlimited");
		else
			System.out.println("" + plannedTestDuration + " seconds");
		System.out.println("# http request timeout = " + plannedRequestTimeout + " seconds");
		if (plannedConnectTimeout != 0)
			System.out.println("# tcp/ip socket connect timeout = " + plannedConnectTimeout + " seconds");
		System.out.println("# startup delay = " + plannedStartupDelay + " milliseconds");
		System.out.println("# statistic sampling interval = " + samplingInterval + " seconds");
		System.out.println("# additional sampling rate per web page call = " + percentilePageSampling + " %");
		System.out.println("# additional sampling rate per url call = " + percentileUrlSampling + " %");
		System.out.println("# extended sampling per url call = " + PerformanceDataTickExtension.extTypeToString(percentileUrlSamplingAddOption).toLowerCase());
		System.out.print("# max loops per user = ");
		if (maxPlannedLoops == 0)
			System.out.println("unlimited");
		else
			System.out.println("" + maxPlannedLoops + " loops");
		if (downlinkBandwidth > 0)
			System.out.println("# max downlink bandwidth per user = " + downlinkBandwidth + " kbps");
		if (uplinkBandwidth > 0)
			System.out.println("# max uplink bandwidth per user = " + uplinkBandwidth + " kbps");
		System.out.println("# http protocol version = v" + httpProtocolVersion);
		System.out.println("# ssl protocol version = " + sslProtocolVersion);
		if (sslSessionCacheTimeout != 0)
			System.out.println("# ssl session cache timeout = " + sslSessionCacheTimeout + " seconds");
		else
			System.out.println("# ssl session cache disabled");
		if (resultFile != null)
			System.out.println("# result file = " + resultFile);
		else
			System.out.println("# no result file");
		if (debugFailedLoops)
			System.out.println("# debug failed loops");
		if (debugLoops)
			System.out.println("# debug loops");
		if (debugHttp)
			System.out.println("# debug http protocol headers");
		if (debugContent)
			System.out.println("# debug http content data");
		if (debugCookies)
			System.out.println("# debug cookies");
		if (debugKeepAlive)
			System.out.println("# debug keep-alive (socket pool)");
		if (debugSsl)
			System.out.println("# debug ssl (https)");
		
		
		// ----------------------------
		// *** initialize load test ***
		// ----------------------------
		
		
		// initialize performance data
		// ---------------------------
		final int PAGE_BREAKS = 1;  // number of page breaks in execute()  - modify this value if you add or delete some page breaks
		final int MAX_THREAD_STEPS = 75;  // number of URL requests in execute() - modify this value if you add or delete some requests
		performanceData = new PerformanceData(PAGE_BREAKS, MAX_THREAD_STEPS, concurrentUsers, -1, plannedTestDuration, maxPlannedLoops, httpProtocolVersion, plannedStartupDelay, plannedRequestTimeout, samplingInterval, percentilePageSampling, percentileUrlSampling, percentileUrlSamplingAddOption);
		performanceData.setInfoText("cldemotesting");
		performanceData.setExecutorsAnnotation(testRunAnnotation);
		if (commonNextProxyConfig != null)
		{
			performanceData.setProxyInfo(proxyHttpHost, proxyHttpPort, proxyHttpsHost, proxyHttpsPort);
			performanceData.addTestDescription("*** Warning: Load test executed via outbound proxy ***");
		}
		performanceData.setResultFileName(resultFile);
		performanceData.setDumpStream(System.out, "# ");
		performanceData.setMaxErrorSnapshots(maxErrorSnapshots);		// 0 = unlimited
		if (maxErrorSnapshotMemory >= 0)
			performanceData.setMaxErrorSnapshotsMemory(maxErrorSnapshotMemory * 1048576l);		// value in bytes
		
		if (sslECC)
			performanceData.addTestDescription("*** Warning: SSL/TLS option -ecc enabled ***");
		
		if ((downlinkBandwidth != 0) || (uplinkBandwidth != 0))
		{
			String downlinkBandwidthStr = "unlimited";
			String uplinkBandwidthStr = "unlimited";
			
			if (downlinkBandwidth != 0)
				downlinkBandwidthStr = "" + downlinkBandwidth + " kbps";
			if (uplinkBandwidth != 0)
				uplinkBandwidthStr = "" + uplinkBandwidth + " kbps";
			
			performanceData.addTestDescription("*** Warning: Max. network bandwidth per user limited. downlink = " + downlinkBandwidthStr + ", uplink = " + uplinkBandwidthStr + " ***");
		}
		
		if ((percentileUrlSamplingAddOption != PerformanceDataTickExtension.EXT_TYPE_NOTYPE) && (percentileUrlSampling > 0))
			performanceData.addTestDescription("*** Warning: Option \"" + PerformanceDataTickExtension.extTypeToString(percentileUrlSamplingAddOption).toLowerCase() + "\" enabled for additional sampling rate per URL call ***");
		if (debugFailedLoops)
			performanceData.addTestDescription("*** Warning: Debug failed loops enabled ***");
		if (debugLoops)
			performanceData.addTestDescription("*** Warning: Debug loops enabled ***");
		if (debugHttp)
			performanceData.addTestDescription("*** Warning: Debug HTTP protocol headers enabled ***");
		if (debugContent)
			performanceData.addTestDescription("*** Warning: Debug HTTP content data enabled ***");
		if (debugCookies)
			performanceData.addTestDescription("*** Warning: Debug cookies enabled ***");
		if (debugKeepAlive)
			performanceData.addTestDescription("*** Warning: Debug keep-alive enabled ***");
		if (debugSsl)
			performanceData.addTestDescription("*** Warning: Debug SSL/TLS enabled ***");
		if (!sslProtocolVersion.equalsIgnoreCase("all"))
			performanceData.addTestDescription("*** Warning: SSL/TLS protocol version fixed to " + sslProtocolVersion.toUpperCase() + " ***");
		if (sslSessionCacheTimeout == 0)
			performanceData.addTestDescription("*** Warning: SSL/TLS session cache disabled ***");
		if (singleUserMode)
		{
			String singleUserModeWarning = "*** Warning: Single user mode enabled ***";
			System.out.println(singleUserModeWarning);
			performanceData.addTestDescription(singleUserModeWarning);
		}
		if (setUserAgentStr != null)
		{
			String overrideUserAgentWarning = "*** Warning: User agent set to \"" + setUserAgentStr + "\" ***";
			System.out.println(overrideUserAgentWarning);
			performanceData.addTestDescription(overrideUserAgentWarning);
		}
		
		
		// ready to start load test...
		initNull(concurrentUsers);
		performanceData.setUserContextTable(getUserContextTable());
		
		// ... but init first remote interface ...
		initRemote(args);
		
		// ... and init plug-in class loader ...
		try
		{
			if (getPluginClassLoader() == null)
				setPluginClassLoader(new LoadtestPluginClassLoader(getSymmetricEncryptContext(), getEncryptedClasspathList()));
		}
		catch (Throwable pluginClassLoaderThrowable)
		{
			System.out.println("*** ERROR: Unable to load encrypted files ***");
			pluginClassLoaderThrowable.printStackTrace();
			System.exit(-1);
		}
		
		// ... and check multihomed option ...
		initMultihomed(args);
		
		// ... and add dynaTrace session ID to load test result - if available ...
		initDynaTrace();
		
		
		// use test-specific DNS hosts file (optional) ?
		String dnsHostsFile = ParseArgs.getIgnoreCaseString(args, "-dnshosts");
		if (dnsHostsFile != null)
		{
			try
			{
				dnsCache = new DNSCache(getSymmetricEncryptContext(), dnsHostsFile);
			}
			catch (IOException ie)
			{
				System.out.println("*** ERROR: unable to read DNS hosts file " + dnsHostsFile + " ***");
				System.out.println("*** Hint: you have to ZIP " + dnsHostsFile + " together with the compiled class of the load test program ***");
				ie.printStackTrace();
				System.exit(-1);
			}
		}
		
		// use test-specific DNS translation table (optional) ?
		String dnsTranslationTableFile = ParseArgs.getIgnoreCaseString(args, "-dnstranslation");
		if (dnsTranslationTableFile != null)
		{
			try
			{
				DNSTranslationTable dnsTranslationTable = new DNSTranslationTable(getSymmetricEncryptContext(), new File(dnsTranslationTableFile));
				if (dnsCache == null)
					dnsCache = new DNSCache();
				dnsCache.setDNSTranslationTable(dnsTranslationTable);
			}
			catch (IOException ie)
			{
				System.out.println("*** ERROR: unable to read DNS translation table file " + dnsTranslationTableFile + " ***");
				System.out.println("*** Hint: you have to ZIP " + dnsTranslationTableFile + " together with the compiled class of the load test program ***");
				ie.printStackTrace();
				System.exit(-1);
			}
		}
		
		// use test-specific DNS servers (optional) ?
		String dnsSrvStr = ParseArgs.getIgnoreCaseString(args, "-dnssrv");
		if (dnsSrvStr != null)
		{
			ArrayList<String> dnsSrvList = new ArrayList<String>();
			StringTokenizer dnsTok = new StringTokenizer(dnsSrvStr, ",;");
			while (dnsTok.hasMoreTokens())
				dnsSrvList.add(dnsTok.nextToken());
			if (dnsCache == null)
				dnsCache = new DNSCache(dnsSrvList);
			else
				dnsCache.setDnsServers(dnsSrvList);
		}
		
		// enable DNS TTL ?
		if (ParseArgs.hasOption(args, "-dnsenattl"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.enableTTL();
		}
		
		// set fixed DNS TTL ?
		Integer dnsFixTTL = ParseArgs.getInteger(args, "-dnsfixttl");
		{
			if (dnsFixTTL != null)
			{
				if (dnsCache == null)
					dnsCache = new DNSCache();
				dnsCache.setFixedTTL(dnsFixTTL.intValue());
			}
		}
		
		// enable DNS resolves per loop ?
		if (ParseArgs.hasOption(args, "-dnsperloop"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsPerLoop = true;
		}
		
		// enable DNS statistic ?   // note: use this option only if not any other, more specific DNS option is enabled.
		if (ParseArgs.hasOption(args, "-dnsstatistic"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
		}
		
		// debug DNS resolver ?
		if (ParseArgs.hasOption(args, "-dnsdebug"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.setDebugToStdout(true);
		}
		
		// enable IPv6 
		if (ParseArgs.hasIgnoreCaseOption(args, "-enableIPv6"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.setEnableIPv6(true);
			String networkInterfaceName = ParseArgs.getString(args, "-enableIPv6");
			if(null != networkInterfaceName && !networkInterfaceName.startsWith("-"))
				dnsCache.setNetworkInterfaceName(networkInterfaceName);
		}
		
		// enable IPv6 and V4 
		if (ParseArgs.hasIgnoreCaseOption(args, "-enableIPv6v4"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.setEnableIPv6v4(true);
			String networkInterfaceName = ParseArgs.getString(args, "-enableIPv6v4");
			if(null != networkInterfaceName && !networkInterfaceName.startsWith("-"))
				dnsCache.setNetworkInterfaceName(networkInterfaceName);
		}
		
		if (dnsCache != null)
		{
			// update performance data with DNS settings
			performanceData.addDNSCacheStatistic(dnsCache.getCacheStatistic());
			performanceData.addTestDescription("*** Warning: OS-independent DNS access enabled. " + dnsCache.getConfigInfoText() + " ***");
			if (dnsPerLoop)
				performanceData.addTestDescription("*** Warning: DNS option -dnsperloop enabled ***");
			
			// log DNS settings
			System.out.println("# OS-independent DNS access enabled. " + dnsCache.getConfigInfoText());
			if (dnsPerLoop)
				System.out.println("# DNS option -dnsperloop enabled");
		}
		
		// calculate sampling offset and virtual user startup offset for cluster jobs (time shift per cluster member)
		int samplingTimeshift = 0;	// value in seconds
		if (!ParseArgs.hasOption(args, "-nosdelayCluster"))
		{
			if ((getClusterTotalMemberCount() > 1) && (getClusterMemberLocalId() > 0))
			{
				samplingTimeshift = Math.round(((float) samplingInterval / (float) getClusterTotalMemberCount()) * (float) getClusterMemberLocalId());
				System.out.println("# samplingTimeshift = " + samplingTimeshift + " seconds");
				
				long startupDelayOffset = (plannedStartupDelay / ((long) getClusterTotalMemberCount())) * ((long) getClusterMemberLocalId());
				System.out.println("# startupDelayTimeshift = " + startupDelayOffset + " milliseconds");
				System.out.println();
				if (startupDelayOffset > 0)
				{
					try { sleepRemoteInterruptable(startupDelayOffset); } catch (InterruptedException ie) {}
				}
			}
		}
		
		
		// update performance data
		// -----------------------
		testDurationStart = System.currentTimeMillis();
		performanceData.setStartDate();
		performanceData.addSnapshot(getCpuUsagePercent());
		performanceData.setSnapshotsTimeshift(samplingTimeshift);
		performanceData.setEndDate();
		
		// initialize global context for plug-ins  
		LoadtestPluginContext globalPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, new cldemotesting());
		
		
		// --------------------------
		// *** start of load test ***
		// ---------------------------
		
		
		// special case for execution plans - start test with zero virtual users
		// ---------------------------------------------------------------------
		if (hasExecutionPlan())
		{
			if (concurrentUsers != 0)
			{
				System.out.println("*** Fatal Error: Load test with execution plan must start with zero number of virtual users - Load test program aborted ***");
				System.exit(1);
			}
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				cldemotesting simulatedUser = new cldemotesting(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				
				HttpLoadTestUserContext userContext = new HttpLoadTestUserContext(simulatedUser, null);
				userContext.setLoadTestUserExecutionPlanPlaceholder();
				getUserContextTable().getUserContextList().add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
		}
		
		
		// start virtual users as threads (normal case)
		// --------------------------------------------
		usersToBeIncreasedAtStartupOffset.set(concurrentUsers);
		for (int x = 0; x < concurrentUsers; x++)
		{
			if (cancelIncrementDecrementUser || cancelInitialIncrementUser)
			{
				usersToBeIncreasedAtStartupOffset.set(0);
				break;
			}
			
			// start load test thread
			// ----------------------
			Thread t = null;
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				cldemotesting simulatedUser = new cldemotesting(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				t = new Thread(simulatedUser);
				String threadName = "" + getUserContextTable().getUserContextList().size();
				threadName = THREAD_NAME.substring(0, 7 - threadName.length()) + threadName;
				t.setName(threadName);
				if (debugLoops && (simulatedUser.getLog().size() > 0))
				{
					synchronized (dumpLock)
					{
						simulatedUser.dumpLog(threadName + " ", System.out);		// dump log of constructor
					}
				}
				HttpLoadTestUserContext userContext = new HttpLoadTestUserContext(simulatedUser, t);
				getUserContextTable().getUserContextList().add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
			t.start();
			usersToBeIncreasedAtStartupOffset.decrementAndGet();
			System.out.println("# --- thread " + t.getName() + " created --- " + ZoneTime.dateToShortString() + " ---");
			
			while (isSuspend())
			{
				try { Thread.currentThread().sleep(100); } catch (InterruptedException ie) { break; }
				if (abortedByRemote() || abortedByEofInputFile())
					break;
				
				// check if max test duration reached during suspend
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
					break;
				
				// display and sample temporary performance data all "sampling interval" seconds - also during suspend
				if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
				{
					performanceData.addSnapshot(getCpuUsagePercent());
					performanceData.setEndDate();
				}
			}
			
			if (abortedByRemote() || abortedByEofInputFile())
				break;
			
			if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				break;
			
			// startup delay for next thread
			// -----------------------------
			try
			{
				if (!singleUserMode)   // create concurrent users
				{
					if (plannedStartupDelay <= 3000)
						sleepRemoteInterruptable(plannedStartupDelay);
					else
					{
						long startupDelayStartTime = System.currentTimeMillis();
						while (true)
						{
							if (abortedByRemote() || abortedByEofInputFile())
								break;
							if ((System.currentTimeMillis() - startupDelayStartTime) >= plannedStartupDelay)
								break;
							
							Thread.currentThread().sleep(100);
							
							// display and sample temporary performance data all "sampling interval" seconds
							if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
							{
								performanceData.addSnapshot(getCpuUsagePercent());
								performanceData.setEndDate();
							}
						}
						while (isSuspend())
						{
							try { Thread.currentThread().sleep(100); } catch (InterruptedException ie) { break; }
							if (abortedByRemote() || abortedByEofInputFile())
								break;
							
							// check if max test duration reached during suspend
							if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
								break;
							
							// display and sample temporary performance data all "sampling interval" seconds - also during suspend
							if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
							{
								performanceData.addSnapshot(getCpuUsagePercent());
								performanceData.setEndDate();
							}
						}
						
					}
				}
				else
					t.join();   // single user mode
			}
			catch (InterruptedException ie) { break; }
			if (abortedByRemote() || abortedByEofInputFile())
				break;
			
			
			// display and sample temporary performance data all "sampling interval" seconds
			if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
			{
				performanceData.addSnapshot(getCpuUsagePercent());
				performanceData.setEndDate();
				if (!isRemote())
				{
					synchronized (dumpLock)
					{
						performanceData.dump(false);
					}
				}
			}
		}
		usersToBeIncreasedAtStartupOffset.set(0);	// just in case that a thread is not started for any reason
		
		
		// wait for test-end in a loop
		// ---------------------------
		boolean allDone = false;
		while (!allDone)
		{
			// test aborted ?
			if (abortedByRemote() || abortedByEofInputFile())
			{
				nearRemoteEnd();
				String abort = "";
				if (abortedByRemote())
					abort = "*** test aborted by remote command ***";
				if (abortedByEofInputFile())
				{
					abort = "*** test aborted at eof of input file ***";
					performanceData.addTestDescription(abort);
				}
				synchronized (dumpLock)
				{
					addSSLCacheStatistic();
					performanceData.addSnapshot(getCpuUsagePercent());
					performanceData.setEndDate();
					
					if (!isRemote())
						performanceData.dump(false);
					if (resultFile != null)
						try { performanceData.writeObjectToFile(getSymmetricEncryptContext(), resultFile); } catch (IOException ie) { ie.printStackTrace(); }
					
					System.out.println();
					System.out.println(abort);
					System.out.println();
					System.out.flush();
					try { Thread.currentThread().sleep(10000); } catch (InterruptedException ie) {}
					System.exit(0);
				}
			}
			
			// display and sample temporary performance data all "sampling interval" seconds
			if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
			{
				performanceData.addSnapshot(getCpuUsagePercent());
				performanceData.setEndDate();
				if (!isRemote())
				{
					synchronized (dumpLock)
					{
						performanceData.dump(false);
					}
				}
			}
			
			// check if test has been done in case of decrement users to zero
			if ((decrementUser) && (plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				decrementUser = false;
			// check if test has been done
			if (!hasExecutionPlan())
				allDone = isTestDone();
			else
			{
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				{
					performanceData.addTestDescription("*** Warning: Load test aborted. Execution plan time limit exceeded after " + plannedTestDuration + " seconds ***");
					triggerAbort();
				}
			}
			
			// if not all is done: sleep one second
			if (!allDone)
				try { sleepRemoteInterruptable(1000); } catch (InterruptedException ie) { break; }
		} // end of wait loop
		
		
		// mark near end of test - only if a remote interface has been used
		nearRemoteEnd();
		
		
		
		// final test result - test completed
		// ----------------------------------
		performanceData.addSnapshot(getCpuUsagePercent());
		performanceData.setEndDate();
		 if(replayMode)
		{
			saveReplaySnapShots("ZTReplay.snapshot");
		}
		
		// save test result
		performanceData.dump(true);
		if (resultFile != null)
			try { performanceData.writeObjectToFile(getSymmetricEncryptContext(), resultFile); } catch (IOException ie) { ie.printStackTrace(); }
		
		// all done
		System.out.flush();
		
		// wait for official end of test - only if a remote interface has been used
		waitRemoteEnd();
		
		System.out.println();
		System.out.println("Result File: " + resultFile);
		
		// now dead
		System.exit(0);
	}


	/**
	 * implement VaryingLoadInterface: support to increment the number of simulated users at runtime.
	 */
	public void setIncrementUser(long startTime)
	{
		incrementUserStartTime = startTime;
		incrementUserFlag = true;
	}

	public boolean isIncrementUser()
	{
		return incrementUserFlag;
	}

	public long getIncrementUserStartTime()
	{
		return incrementUserStartTime;
	}

	public void setIncrementUserStartTime(long startTime)
	{
		incrementUserStartTime = startTime;
	}

	public void clearIncrementUser()
	{
		incrementUserFlag = false;
	}

	public int incrementUsers(int numAddUsers, long startupDelay)
	{
		if (startupDelay < 0)
			startupDelay = plannedStartupDelay;
		return incrementUsersImplementation(numAddUsers, startupDelay, this);
	}

	static int incrementUsersImplementation(int numAddUsers, long startupDelay, HttpLoadTest httpLoadTest)
	{
		long startupDelayOffset = 0;
		if ((getClusterTotalMemberCount() > 1) && (getClusterMemberLocalId() > 0))
			startupDelayOffset = (startupDelay / ((long) getClusterTotalMemberCount())) * ((long) getClusterMemberLocalId());
		
		ArrayList<HttpLoadTestUserContext> addUserContextList = new ArrayList<HttpLoadTestUserContext>(numAddUsers);
		for (int x = 0; x < numAddUsers; x++)
		{
			if (abortedByRemote() || abortedByEofInputFile())
				return x;
			
			// initialize load test thread
			// ---------------------------
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				cldemotesting simulatedUser = new cldemotesting(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				HttpLoadTestUserContext userContext = prepareIncrementUser(simulatedUser, System.currentTimeMillis() + startupDelayOffset + (x * startupDelay));
				addUserContextList.add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
				if (debugLoops && (simulatedUser.getLog().size() > 0))
				{
					synchronized (dumpLock)
					{
						simulatedUser.dumpLog(userContext.getLoadTestThread().getName() + " ", System.out);		// dump log of constructor
					}
				}
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
		}
		
		// start load test threads by a thread
		// -----------------------------------
		HttpLoadTestIncrementUserThread incrementUserThread = new HttpLoadTestIncrementUserThread(httpLoadTest, addUserContextList);
		incrementUserThread.start();
		return numAddUsers;
	}


	/**
	 * Internal method used to load and apply next proxy settings from ZBAProxySettings.properties file.
	 * Settings are applied only if file exists and nextProxyIsActive is set to true in the file.
	 * Note that settings stored with the session, will be ineffective.
	 *
	 * @since V5.5-D
	 */
	private void applyNextProxySettingsFromFileIfExists()
	{
		
		String filename = "ZBAProxySettings.properties";
		BufferedReader bin = null;
		SymmetricEncryptContext decryptContext = getSymmetricEncryptContext();
		File file = new File(filename);
		
		if (file.exists())
		// open input file
		try
		{
			if (decryptContext == null)
			{
				bin = new BufferedReader(new InputStreamReader(new FileInputStream(filename), Charset.forName("UTF-8")));
			}
			else
			{
				// create a reader stream that decrypts the data on the fly
				bin = new BufferedReader(new InputStreamReader(SymmetricEncrypt.getCipherInputStream(new FileInputStream(filename), decryptContext), Charset.forName("UTF-8")));
			}
			
			if (bin != null)
			{
				Properties nextProxyConfigProperties = new Properties();
				nextProxyConfigProperties.load(bin);
				NextProxyConfig nextProxyConfig = new NextProxyConfig();
				nextProxyConfig.setActive(Boolean.valueOf(nextProxyConfigProperties.getProperty("nextProxyIsActive")));
				proxyEnabled = nextProxyConfig.isActive();                             // if false: do not use a proxy server
				
				if (proxyEnabled)
				{
					nextProxyConfig.disableHttpProxyCache(Boolean.valueOf(nextProxyConfigProperties.getProperty("nextProxyHttpCacheDisabled")));
					proxyCacheDisabled = nextProxyConfig.isDisabledHttpProxyCache();
					nextProxyConfig.setHttpHost(nextProxyConfigProperties.getProperty("nextProxyHttpHost"));
					proxyHttpHost = nextProxyConfig.getHttpHost();
					nextProxyConfig.setHttpPort(Integer.valueOf(nextProxyConfigProperties.getProperty("nextProxyHttpPort")));
					proxyHttpPort = nextProxyConfig.getHttpPort();
					nextProxyConfig.setHttpsHost(nextProxyConfigProperties.getProperty("nextProxyHttpsHost"));
					proxyHttpsHost = nextProxyConfig.getHttpsHost();
					nextProxyConfig.setHttpsPort(Integer.valueOf(nextProxyConfigProperties.getProperty("nextProxyHttpsPort")));
					proxyHttpsPort = nextProxyConfig.getHttpsPort();
					nextProxyConfig.setAuthUsername(nextProxyConfigProperties.getProperty("nextProxyAuthUsername"));
					nextProxyConfig.setAuthPassword(nextProxyConfigProperties.getProperty("nextProxyAuthPassword"));
					nextProxyConfig.setNoNextProxy(nextProxyConfigProperties.getProperty("noNextProxy"));
					noProxyFor = nextProxyConfig.getNoNextProxy();
					
					String proxyAuth = "";
					
					if (nextProxyConfig.getAuthUsername() != null)
					{
						proxyAuth = nextProxyConfig.getAuthUsername() + ":";
						if (nextProxyConfig.getAuthPassword() != null)
							proxyAuth = proxyAuth + nextProxyConfig.getAuthPassword();
					}
					
					String  proxyAuthorization = null;
					
					if (proxyAuth.length() > 1)
						proxyAuthorization = Base64Encoder.encode(proxyAuth);		// Base 64 encoded - used for basic authentication only
					
					commonNextProxyConfig = new NextProxyConfig(proxyEnabled, proxyCacheDisabled, proxyHttpHost, proxyHttpPort, proxyHttpsHost, proxyHttpsPort, proxyAuthorization, noProxyFor);
					
					log("*** Warning: Applying proxy configuration from file " + filename + " ***");
				}
				
			}
		}
		catch (Throwable tr)
		{
			log("*** Unable to load proxy configuration from properties file " + filename + " ***");
			tr.printStackTrace();
		}
		finally
		{
			if (bin != null)
			{
				try { bin.close(); } catch (Exception e) {}
			}
		}
		
	}
		

}	// end of class

