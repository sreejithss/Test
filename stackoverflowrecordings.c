stackoverflowrecordings()
{

	web_set_sockets_option("SSL_VERSION", "2&3");

	web_url("seed", 
		"URL=https://clients4.google.com/chrome-variations/seed?osname=win", 
		"Resource=0", 
		"Referer=", 
		"Snapshot=t1.inf", 
		"Mode=HTML", 
		LAST);

	web_custom_request("rappor", 
		"URL=https://clients4.google.com/rappor", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t2.inf", 
		"Mode=HTML", 
		"EncType=application/vnd.chrome.rappor", 
		"BodyBinary=\\x08\\x80\\x03\\x12\\x1B\t\\xB6\"\\xE3\\xAE\\xB9\\xCAE\\xE2\\x12\\x10)3\\x08\\xA7\\x15\\x0E)\\x86)^C\\xFC\\x84\\x10\\x10!\\x12\\x1B\t\\xB2U\\xE18[\\xEE\\x9E\\xBA\\x12\\x10%0\\x1E\"\\x99\\x0Ep[\\x06\\xC9E\\xFA\\x0C)f\\x0C", 
		EXTRARES, 
		"Url=https://ssl.gstatic.com/safebrowsing/csd/client_model_v5_variation_0.pb", "Referer=", ENDITEM, 
		"Url=https://ssl.gstatic.com/safebrowsing/csd/client_model_v5_ext_variation_0.pb", "Referer=", ENDITEM, 
		LAST);

	web_add_cookie("__qca=P0-81082907-1471603250711; DOMAIN=clc.stackoverflow.com");

	web_add_cookie("_ga=GA1.2.1548115758.1471603251; DOMAIN=clc.stackoverflow.com");

	web_add_cookie("_gat=1; DOMAIN=clc.stackoverflow.com");

/*Correlation comment - Do not change!  Original value='73b2fcfc-b221-8f12-4d24-b230b5a0988d' Name ='prov' Type ='ResponseBased'*/
	web_reg_save_param_regexp(
		"ParamName=prov",
		"RegExp=prov=(.*?);",
		SEARCH_FILTERS,
		"Scope=Cookies",
		"IgnoreRedirections=No",
		"RequestUrl=*/stackoverflow.com/*",
		LAST);

/*Correlation comment - Do not change!  Original value='17440561' Name ='c2' Type ='ResponseBased'*/
	web_reg_save_param_regexp(
		"ParamName=c2",
		"RegExp=,\\ c2:\\ \"(.*?)\"\\ }\\)",
		SEARCH_FILTERS,
		"Scope=Body",
		"IgnoreRedirections=No",
		"RequestUrl=*/stackoverflow.com/*",
		LAST);

	web_url("stackoverflow.com", 
		"URL=https://stackoverflow.com/", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=https://cdn.sstatic.net/img/share-sprite-new.svg?v=78be252218f3", "Referer=https://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM, 
		"Url=https://cdn.sstatic.net/Sites/stackoverflow/img/sprites.svg?v=8c1c8cba242e", "Referer=https://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM, 
		"Url=https://cdn.sstatic.net/img/documentation/hero-mockup.svg?v=e4c3945429e4", "Referer=https://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM, 
		"Url=https://cdn.sstatic.net/img/documentation/bg-hero.svg?v=0f7700497ec8", "Referer=https://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM, 
		"Url=https://cdn.sstatic.net/clc/clc.min.js?v=84432a71b7a2", ENDITEM, 
		"Url=https://cdn.sstatic.net/img/favicons-sprite16.png?v=1e9861561e7d", "Referer=https://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM, 
		"Url=https://cdn.sstatic.net/Js/full-anon.en.js?v=defe71715ff8", ENDITEM, 
		"Url=https://www.google-analytics.com/analytics.js", ENDITEM, 
		"Url=https://secure.quantserve.com/quant.js", ENDITEM, 
		"Url=https://www.google-analytics.com/r/collect?v=1&_v=j44&a=1978212664&t=pageview&_s=1&dl=https%3A%2F%2Fstackoverflow.com%2F&ul=sv&de=UTF-8&dt=Stack%20Overflow&sd=24-bit&sr=1920x1080&vp=1903x979&je=0&fl=22.0%20r0&_u=AEAAAAABI~&jid=1295775398&cid=1548115758.1471603251&tid=UA-5620270-1&_r=1&z=1548674214", ENDITEM, 
		"Url=https://engine.adzerk.net/ados.js", ENDITEM, 
		"Url=https://sb.scorecardresearch.com/beacon.js", ENDITEM, 
		"Url=https://pixel.quantserve.com/pixel;r=458061004;a=p-c1rF4kxgLUzNc;fpan=1;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603250705;tzo=420;ref=;url=https%3A%2F%2Fstackoverflow.com%2F;ogl=type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.Stack%20Overflow%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2F", ENDITEM, 
		"Url=https://engine.adzerk.net/ados?t=1471603251359&request={%22Placements%22:[{%22A%22:22,%22S%22:8277,%22D%22:%22adzerk1452929724%22,%22ATA%22:[5,17,2221],%22Z%22:[45]}],%22Keywords%22:%22undefined%22,%22Referrer%22:%22%22,%22IsAsync%22:true}", ENDITEM, 
		"Url=https://engine.adzerk.net/i.gif?e=eyJhdiI6NDE0LCJhdCI6NSwiYnQiOjAsImNtIjo0MDQyODMsImNoIjoxMTc4LCJjayI6e30sImNyIjoxNDM0MzE3LCJkaSI6ImQ0ZTMzMjJjZDdkMzRkZTE5MTBmYTVhMmI5ZTU1MGQ4IiwiZG0iOjEsImZjIjoxNjQ5MzM3LCJmbCI6MTQ0ODM0MiwiaXAiOiIxOTQuMjEzLjExOS41IiwibnciOjIyLCJwYyI6MCwiZWMiOjAsInByIjoxNjA0LCJydCI6MSwic3QiOjgyNzcsInVrIjoidWUxLWVjNDZhYmVlZTNlMTRhNjRhYzIyZTEyZWRmYWNhNDU5Iiwiem4iOjQ1LCJ0cyI6MTQ3MTYwMzI1MTY5OSwiYmYiOnRydWUsInBuIjoiYWR6ZXJrMTQ1MjkyOTcyNCIsImZxIjowfQ&s=jPLBWAvC8kc7ofVhzVwbalQi214", ENDITEM, 
		"Url=https://s.zkcdn.net/Extensions/adFeedback.css", ENDITEM, 
		"Url=https://s.zkcdn.net/Extensions/adFeedback.js", ENDITEM, 
		"Url=https://s.zkcdn.net/Advertisers/56c98ff2ade9414bb75b7dda3a9baaca.png", ENDITEM, 
		"Url=https://clc.stackoverflow.com/p.js?zones=2%3Dhireme&host=stackoverflow.com&lw=1341&bw=1920&az=1", ENDITEM, 
		"Url=https://cdn.sstatic.net/clc/styles/clc/jobs-multi.min.css?v=a28a58104dce", ENDITEM, 
		"Url=https://clc.stackoverflow.com/soi.gif?an=Y2NiWKJ10Vf2xGUPBhBgZWRYl83MysTAxMDOCORzgASZJJ8wMWR-3f150fyt9kxgSUY5BkaGiw7M2ISFtMEaWBn-M4JUgOjcbXpKctsObMx5DwA&at=0&pt=5839", ENDITEM, 
		LAST);

	web_add_cookie("prov={prov}; DOMAIN=stackoverflow.com");

	web_add_cookie("__qca=P0-81082907-1471603250711; DOMAIN=stackoverflow.com");

	web_add_cookie("_ga=GA1.2.1548115758.1471603251; DOMAIN=stackoverflow.com");

	web_add_cookie("_gat=1; DOMAIN=stackoverflow.com");

	web_custom_request("event", 
		"URL=https://stackoverflow.com/gps/event", 
		"Method=POST", 
		"Resource=0", 
		"Referer=https://stackoverflow.com/", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=[{\"evt\":\"docs.hero.show\",\"properties\":{\"location\":1},\"now\":1471603251269}]", 
		LAST);

	web_url("b",
		"URL=https://sb.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603251349&ns_c=UTF-8&cv=3.1&c8=Stack%20Overflow&c7=https%3A%2F%2Fstackoverflow.com%2F&c9=",
		"Resource=0",
		"Referer=https://stackoverflow.com/",
		"Snapshot=t5.inf",
		"Mode=HTML",
		EXTRARES,
		"URL=https://cdn.sstatic.net/clc/img/jobs/ico-dismiss.svg?v=0cbd6b4ab039", "Referer=https://cdn.sstatic.net/clc/styles/clc/jobs-multi.min.css?v=a28a58104dce", ENDITEM,
		"URL=https://cdn.sstatic.net/clc/img/jobs/ico-location-gray.svg?v=0cbd6b4ab039", "Referer=https://cdn.sstatic.net/clc/styles/clc/jobs-multi.min.css?v=a28a58104dce", ENDITEM,
		LAST);

	web_url("login", 
		"URL=https://stackoverflow.com/users/login?ssrc=head&returnurl=http%3a%2f%2fstackoverflow.com%2f", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=https://stackoverflow.com/", 
		"Snapshot=t6.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=https://cdn.sstatic.net/img/openid/universal-login-sprite.svg?v=3ca03e653513", "Referer=https://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM, 
		LAST);

	lr_think_time(5);

	web_url("b_2",
		"URL=https://sb.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603258987&ns_c=UTF-8&cv=3.1&c8=Log%20In%20-%20Stack%20Overflow&c7=https%3A%2F%2Fstackoverflow.com%2Fusers%2Flogin%3Fssrc%3Dhead%26returnurl%3Dhttp%253a%252f%252fstackoverflow.com%252f&c9=https%3A%2F%2Fstackoverflow.com%2F",
		"Resource=0",
		"Referer=https://stackoverflow.com/users/login?ssrc=head&returnurl=http%3a%2f%2fstackoverflow.com%2f",
		"Snapshot=t7.inf",
		"Mode=HTML",
		EXTRARES,
		"URL=https://pixel.quantserve.com/pixel;r=1924546816;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603258891;tzo=420;ref=https%3A%2F%2Fstackoverflow.com%2F;url=https%3A%2F%2Fstackoverflow.com%2Fusers%2Flogin%3Fssrc%3Dhead%26returnurl%3Dhttp%253a%252f%252fstackoverflow.com%252f;ogl=type.website%2Cimage.https%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a8%2Ctitle.Log%20In%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.https%3A%2F%2Fstackoverflow%252Ecom%2Fusers%2Flogin%3Fssrc%3Dhead%26returnurl%3Dhttp%3A%252f%252fstackoverfl", "Referer=https://stackoverflow.com/users/login?ssrc=head&returnurl=http%3a%2f%2fstackoverflow.com%2f", ENDITEM,
		LAST);

	web_custom_request("query", 
		"URL=https://clients1.google.com/tbproxy/af/query?client=Google%20Chrome", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/proto", 
		"Referer=", 
		"Snapshot=t8.inf", 
		"Mode=HTML", 
		"EncType=text/proto", 
		"BodyBinary=\n\\x176.1.1715.1442/en (GGLL)\\x13\\x19\\x8A\\\\Zr\\x18\\xF2\\xE6\\xCD#-\\x83\\xA8[=$#-\\xCEALz$#-a\\xEA\\xDB9$#-\\xA5R\\xE0\\xE4$\\x14", 
		LAST);

	web_custom_request("v2", 
		"URL=https://clients4.google.com/uma/v2", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t9.inf", 
		"ContentEncoding=gzip", 
		"Mode=HTML", 
		"EncType=application/vnd.chrome.uma", 
		body_variable_1, 
		LAST);

	web_custom_request("event_2", 
		"URL=https://stackoverflow.com/gps/event", 
		"Method=POST", 
		"Resource=0", 
		"Referer=https://stackoverflow.com/users/login?ssrc=head&returnurl=http%3a%2f%2fstackoverflow.com%2f", 
		"Snapshot=t10.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=[{\"evt\":\"login.start\",\"properties\":{},\"now\":1471603265035}]", 
		LAST);

	web_custom_request("event_3", 
		"URL=https://stackoverflow.com/gps/event", 
		"Method=POST", 
		"Resource=0", 
		"Referer=https://stackoverflow.com/users/login?ssrc=head&returnurl=http%3a%2f%2fstackoverflow.com%2f", 
		"Snapshot=t11.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=[{\"evt\":\"openid.click\",\"properties\":{\"openid_provider\":\"google\",\"location\":\"users_login\"},\"now\":1471603265133}]", 
		EXTRARES, 
		"Url=https://ssl.gstatic.com/images/icons/ui/common/universal_language_settings-21.png", "Referer=https://accounts.google.com/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/auth?scope%3Dprofile%2Bemail%26response_type%3Dcode%26redirect_uri%3Dhttps://stackauth.com/auth/oauth2/google%26state%3D%257B%2522sid%2522:1,%2522st%2522:%25228297fee1a3814ffcc28211bde85a8547a87b2a95305a71e125e6bd3f072660d4%2522,%2522ses%2522"
		":%2522843eaf544f494d9d88b7294778c6d681%2522%257D%26client_id%3D717762328687-p17pldm5fteklla3nplbss3ai9slta0a.apps.googleusercontent.com%26from_login%3D1%26as%3D3309f1023c2fae66&oauth=1&sarp=1&scc=1", ENDITEM, 
		"Url=https://www.gstatic.com/images/icons/material/system/1x/arrow_back_grey600_24dp.png", "Referer=https://accounts.google.com/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/auth?scope%3Dprofile%2Bemail%26response_type%3Dcode%26redirect_uri%3Dhttps://stackauth.com/auth/oauth2/google%26state%3D%257B%2522sid%2522:1,%2522st%2522:%25228297fee1a3814ffcc28211bde85a8547a87b2a95305a71e125e6bd3f072660d4%2522,%2522ses%2522"
		":%2522843eaf544f494d9d88b7294778c6d681%2522%257D%26client_id%3D717762328687-p17pldm5fteklla3nplbss3ai9slta0a.apps.googleusercontent.com%26from_login%3D1%26as%3D3309f1023c2fae66&oauth=1&sarp=1&scc=1", ENDITEM, 
		"Url=https://ssl.gstatic.com/images/branding/googlelogo/1x/googlelogo_color_112x36dp.png", "Referer=https://accounts.google.com/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/auth?scope%3Dprofile%2Bemail%26response_type%3Dcode%26redirect_uri%3Dhttps://stackauth.com/auth/oauth2/google%26state%3D%257B%2522sid%2522:1,%2522st%2522:%25228297fee1a3814ffcc28211bde85a8547a87b2a95305a71e125e6bd3f072660d4%2522,%2522ses%2522"
		":%2522843eaf544f494d9d88b7294778c6d681%2522%257D%26client_id%3D717762328687-p17pldm5fteklla3nplbss3ai9slta0a.apps.googleusercontent.com%26from_login%3D1%26as%3D3309f1023c2fae66&oauth=1&sarp=1&scc=1", ENDITEM, 
		"Url=https://ssl.gstatic.com/accounts/ui/avatar_2x.png", "Referer=https://accounts.google.com/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/auth?scope%3Dprofile%2Bemail%26response_type%3Dcode%26redirect_uri%3Dhttps://stackauth.com/auth/oauth2/google%26state%3D%257B%2522sid%2522:1,%2522st%2522:%25228297fee1a3814ffcc28211bde85a8547a87b2a95305a71e125e6bd3f072660d4%2522,%2522ses%2522"
		":%2522843eaf544f494d9d88b7294778c6d681%2522%257D%26client_id%3D717762328687-p17pldm5fteklla3nplbss3ai9slta0a.apps.googleusercontent.com%26from_login%3D1%26as%3D3309f1023c2fae66&oauth=1&sarp=1&scc=1", ENDITEM, 
		"Url=https://ssl.gstatic.com/accounts/ui/wlogostrip_230x17_1x.png", "Referer=https://accounts.google.com/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/auth?scope%3Dprofile%2Bemail%26response_type%3Dcode%26redirect_uri%3Dhttps://stackauth.com/auth/oauth2/google%26state%3D%257B%2522sid%2522:1,%2522st%2522:%25228297fee1a3814ffcc28211bde85a8547a87b2a95305a71e125e6bd3f072660d4%2522,%2522ses%2522"
		":%2522843eaf544f494d9d88b7294778c6d681%2522%257D%26client_id%3D717762328687-p17pldm5fteklla3nplbss3ai9slta0a.apps.googleusercontent.com%26from_login%3D1%26as%3D3309f1023c2fae66&oauth=1&sarp=1&scc=1", ENDITEM, 
		"Url=https://fonts.gstatic.com/s/opensans/v13/DXI1ORHCpsQm3Vp6mXoaTegdm0LZdjqr5-oayXSOefg.woff2", "Referer=https://accounts.google.com/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/auth?scope%3Dprofile%2Bemail%26response_type%3Dcode%26redirect_uri%3Dhttps://stackauth.com/auth/oauth2/google%26state%3D%257B%2522sid%2522:1,%2522st%2522:%25228297fee1a3814ffcc28211bde85a8547a87b2a95305a71e125e6bd3f072660d4%2522,%2522ses%2522"
		":%2522843eaf544f494d9d88b7294778c6d681%2522%257D%26client_id%3D717762328687-p17pldm5fteklla3nplbss3ai9slta0a.apps.googleusercontent.com%26from_login%3D1%26as%3D3309f1023c2fae66&oauth=1&sarp=1&scc=1", ENDITEM, 
		"Url=https://fonts.gstatic.com/s/opensans/v13/cJZKeOuBrn4kERxqtaUH3VtXRa8TVwTICgirnJhmVJw.woff2", "Referer=https://accounts.google.com/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/auth?scope%3Dprofile%2Bemail%26response_type%3Dcode%26redirect_uri%3Dhttps://stackauth.com/auth/oauth2/google%26state%3D%257B%2522sid%2522:1,%2522st%2522:%25228297fee1a3814ffcc28211bde85a8547a87b2a95305a71e125e6bd3f072660d4%2522,%2522ses%2522"
		":%2522843eaf544f494d9d88b7294778c6d681%2522%257D%26client_id%3D717762328687-p17pldm5fteklla3nplbss3ai9slta0a.apps.googleusercontent.com%26from_login%3D1%26as%3D3309f1023c2fae66&oauth=1&sarp=1&scc=1", ENDITEM, 
		LAST);

	/*Possible OAUTH authorization was detected. It is recommended to correlate the authorization parameters.*/

	web_url("CheckConnection", 
		"URL=https://accounts.youtube.com/accounts/CheckConnection?pmpo=https%3A%2F%2Faccounts.google.com&v=1259187754&timestamp=1471603281152", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=https://accounts.google.com/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/auth?scope%3Dprofile%2Bemail%26response_type%3Dcode%26redirect_uri%3Dhttps://stackauth.com/auth/oauth2/google%26state%3D%257B%2522sid%2522:1,%2522st%2522:%25228297fee1a3814ffcc28211bde85a8547a87b2a95305a71e125e6bd3f072660d4%2522,%2522ses%2522"
		":%2522843eaf544f494d9d88b7294778c6d681%2522%257D%26client_id%3D717762328687-p17pldm5fteklla3nplbss3ai9slta0a.apps.googleusercontent.com%26from_login%3D1%26as%3D3309f1023c2fae66&oauth=1&sarp=1&scc=1", 
		"Snapshot=t12.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=https://www.google.com/favicon.ico", "Referer=https://accounts.google.com/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/auth?scope%3Dprofile%2Bemail%26response_type%3Dcode%26redirect_uri%3Dhttps://stackauth.com/auth/oauth2/google%26state%3D%257B%2522sid%2522:1,%2522st%2522:%25228297fee1a3814ffcc28211bde85a8547a87b2a95305a71e125e6bd3f072660d4%2522,%2522ses%2522"
		":%2522843eaf544f494d9d88b7294778c6d681%2522%257D%26client_id%3D717762328687-p17pldm5fteklla3nplbss3ai9slta0a.apps.googleusercontent.com%26from_login%3D1%26as%3D3309f1023c2fae66&oauth=1&sarp=1&scc=1", ENDITEM, 
		"Url=https://lh3.googleusercontent.com/-XdUIqdMkCWA/AAAAAAAAAAI/AAAAAAAAAAA/4252rscbv5M/photo.jpg?sz=96", "Referer=https://accounts.google.com/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/auth?scope%3Dprofile%2Bemail%26response_type%3Dcode%26redirect_uri%3Dhttps://stackauth.com/auth/oauth2/google%26state%3D%257B%2522sid%2522:1,%2522st%2522:%25228297fee1a3814ffcc28211bde85a8547a87b2a95305a71e125e6bd3f072660d4%2522,%2522ses%2522"
		":%2522843eaf544f494d9d88b7294778c6d681%2522%257D%26client_id%3D717762328687-p17pldm5fteklla3nplbss3ai9slta0a.apps.googleusercontent.com%26from_login%3D1%26as%3D3309f1023c2fae66&oauth=1&sarp=1&scc=1", ENDITEM, 
		LAST);

	lr_think_time(5);

	web_url("SetSID", 
		"URL=https://accounts.youtube.com/accounts/SetSID?ssdc=1&sidt=ALWU2ctbnXgtvs1x1iRtpLP%2BfReY%2B2YlcvxueJwo2omMPxWMOPSNYwbH77BRZM%2BabkdyaMiGWjd%2BxhCArQ%2FT2Yd66pDxIm5GhhhmhqeNdyDiuo0TUlS8hr9AdYo3atXmJ3mns5IZF5UaTaW%2BSDWhHnPQFWotNrzkTpbv%2FrMl%2FJIoYlRMCf3uzOu7o0sH%2BKJy4xc7Uh2pNSJ4xqCLKgUHRcrnjSkaJmQ5sOEA62P0Jobv6lZvSIcpNd5YY3hNcKDN%2B3z6ZuHxr4SDgx63QcCXfcLnL1vvXyQrUnVLkT09hhE%2FvLC9qQB8B0s%3D&pmpo=https%3A%2F%2Faccounts.google.com", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=https://accounts.google.com/signin/challenge/sl/password", 
		"Snapshot=t13.inf", 
		"Mode=HTML", 
		LAST);

	web_url("SetSID_2", 
		"URL=https://accounts.google.se/accounts/SetSID?ssdc=1&sidt=ALWU2ctCQiuJAYPARllj1XEuc5VC3kIQygWWg5rjw6PHTOBR4WvJZLMEeub6Y6IuoafSGh%2FcmY6ilt6%2F6A%2BC4FDLjigc6tqylM%2B5S9XPaD7Uqtp7Fm%2B6Iouq80UoBEzPrzNMcAfAv61UMjahElsnbCTvdlSrujbCk%2FDCVzbUdJX7OjEdLBZ9uTFAlRioioOUard6owiNHDZ0pk%2Bw%2FTe9yMwyfa3nFbBMVyR5wr4H2IneeJ9QqPlIS7QB6HhqV5rqdfKydm3D2nhQNEjFlj%2BKTaq%2FhYPHLPXWXhIwkFtIuLLp0T2IGV3kags%3D&pmpo=https%3A%2F%2Faccounts.google.com", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=https://accounts.google.com/signin/challenge/sl/password", 
		"Snapshot=t14.inf", 
		"Mode=HTML", 
		LAST);

	web_add_cookie("uauth=true; DOMAIN=stackoverflow.com");

	web_add_cookie("acct=t=R4AltQme5Kz45o%2fNg7BtxXPAjKVbAAmF&s=09gLGgVV3o3h5Ruu%2f5wqdAg3X3YKB3iq; DOMAIN=stackoverflow.com");

/*Correlation comment - Do not change!  Original value='be31f974939de42ac763d026ec67260e' Name ='fkey' Type ='ResponseBased'*/
	web_reg_save_param_regexp(
		"ParamName=fkey",
		"RegExp=aceAfterNameTabCompletion\":false,\"id\":1,\"enableInsertDocLinkDialog\":true,\"enableSocialMediaInSharePopup\":true},\"user\":\\{\"fkey\":\"(.*?)\",",
		SEARCH_FILTERS,
		"Scope=Body",
		"IgnoreRedirections=Yes",
		"RequestUrl=*/stackoverflow.com/*",
		LAST);

	web_url("google", 
		"URL=https://stackauth.com/auth/oauth2/google?state=%7B%22sid%22:1,%22st%22:%228297fee1a3814ffcc28211bde85a8547a87b2a95305a71e125e6bd3f072660d4%22,%22ses%22:%22843eaf544f494d9d88b7294778c6d681%22%7D&code=4/57b-quXXuDp6S6I71pEzd0fzXcGYdY6To3mqi2gb0EI", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t15.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://cdn.sstatic.net/img/share-sprite-new.svg?v=78be252218f3", "Referer=http://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM, 
		"Url=http://cdn.sstatic.net/Sites/stackoverflow/img/sprites.svg?v=8c1c8cba242e", "Referer=http://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM, 
		"Url=http://cdn.sstatic.net/clc/clc.min.js?v=84432a71b7a2", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://cdn.sstatic.net/img/documentation/bg-hero.svg?v=0f7700497ec8", "Referer=http://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM, 
		"Url=http://cdn.sstatic.net/img/documentation/hero-mockup.svg?v=e4c3945429e4", "Referer=http://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM, 
		"Url=http://cdn.sstatic.net/img/favicons-sprite16.png?v=1e9861561e7d", "Referer=http://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM, 
		"Url=http://static.adzerk.net/ados.js", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://b.scorecardresearch.com/beacon.js", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://edge.quantserve.com/quant.js", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://cdn.sstatic.net/Js/full.en.js?v=95c6cd6073b9", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://pixel.quantserve.com/pixel;r=954378653;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603316556;tzo=420;ref=;url=http%3A%2F%2Fstackoverflow.com%2F%23;ogl=type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.Stack%20Overflow%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2F", "Referer="
		"http://stackoverflow.com/", ENDITEM, 
		"Url=http://clc.stackoverflow.com/to.gif", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://engine.adzerk.net/ados?t=1471603316530&request={%22Placements%22:[{%22A%22:22,%22S%22:8277,%22D%22:%22adzerk212998260%22,%22ATA%22:[5,17,2221],%22Z%22:[45]}],%22Keywords%22:%22x-user-registered%22,%22Referrer%22:%22%22,%22IsAsync%22:true}", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://static.adzerk.net/Extensions/adFeedback.js", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://static.adzerk.net/Extensions/adFeedback.css", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://stackexchange.com/users/login/universal.gif?authToken=3UY6sYiEJDGcPTDYGYZ1NYJ%2B5xiEnZNTnmh%2FX7IXssYyvgDJ44%2B93rbp6ihBXJN9YDNKhEHcN8j8CiQEja8jze1P%2FPYP1gTCyZjhhXY6NpzDQsCbFNVtWjGWIcdfwnTPzstBgKSGL5uEv%2Bm8taUp%2FUpEYBljDoJV0w1MxgK5X0XvSRrJRDO1LYBVFZ2Zll5BBIi%2F%2Fr%2FhU%2FxB%2Bsm%2BGuREMBl4oEKXntjIW0npX0XWEkJseSxnuqM022cN7Zrj6OmMkeCEHSRUmgLXdRwyY5vWiUaPjud7fpMPfR0FT310l8fVewr5uBbSrhtyJ9IPnYbI&nonce=deK2VwAAAACg5QfLSTVJDQ%3D%3D", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://serverfault.com/users/login/universal.gif?authToken=yeUpKXBfTsNc5b2X8QWoDH7dSFWCueDD67zwIYa8RC4vIj9qiMoPvjdF1WVqJBx5u7AEzpfQN4dPXDw7HYteFWbFl84h7O%2B9OZybOl3MO8GyrGb0tp%2FDSjvBKG7dwEGUJmIhex%2FeTA483Co2Q5aFmYuBh%2BytPKq9mExP%2FXoAqCtPaR3F4tEXLV4hC63yj0ScobbUcpL5CNaL9k%2FolDUpXf2oNIREC3aJRJMWYQzh1YqgNSmcVwJHjY%2FDSvq45HFdXigEM6lmzh0KTXrBX5KkmxWTOeX3wXSx5TCYpjBS9ZQ%3D&nonce=deK2VwAAAACjZ9tHKDHhWA%3D%3D", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://askubuntu.com/users/login/universal.gif?authToken=R1PH19blOsI3SImzSPPOCvoriHu4pNldP15shI7EjooTlJ0VOqozG0ES9WPH8SsqXn9cIy8h%2BygJsmM3o3AMXf894BlJk89MEVgz3RbAcrfJ38%2FgmywNLT7ktxCKlbYGXtB0jlU1fbAY9MMyX%2BfjgevIacFagIvq2q7MZ203ejopbaf3MFfjPKZs4lteVP5fP8dQoyAYY%2BfmOpZix0vjpKWDhToauSExG%2Bb9jSWOorjNegwtf5GlXUdT6G5ZMGPz%2BEGAEVlASt3FrAvFeCe7EZy%2F8Ig%2Foyu0gR%2F%2B5Rk0Nik%3D&nonce=deK2VwAAAABQ3rU%2BK53%2FTg%3D%3D", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://superuser.com/users/login/universal.gif?authToken=n6We%2FPFq%2BkMGJquqmE0nraZOjR5H9CBRzpjQIfLrVSYec7ub65hUmKZVWrillbG5UFrryauTrmLg5QpuRusvtjz%2FHB9HoQOA%2Fb%2FlgwHorzzyoHQJfve5JevQVLgniRjVT8PzE23EbXeQ63lYqOyYuHZRIQFYMRbUJOLHLmGD8LODl%2BxyAvzxVzAkWAljYKocRuz2k0GlHXwBrvb2gFhQslIjgTFaWJfCyi%2BQccd36IbS0itIns8UVTKbyA3elcP2R8wc1EfesAMju6tApkIiYWR1GqqFm0mplOCI6UUHYTo%3D&nonce=deK2VwAAAADPVTKt%2FjSFUw%3D%3D", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://stackapps.com/users/login/universal.gif?authToken=5xwKG5qUR3EtElssfz85ZMl302Vq%2Fd9loFVD1FkEgkXt4M1c%2FkYIlqsZmgAfcwDcyawhihOzoekq3UKFSTHhG9okzhhn3H9s%2BXZ17BJeuZD4FlM%2Fij0b595WFsTPb7yyVHFyKsyDi4nY343jN2yqbh%2B564uk7NTK8DI4yYbkP7ZGmeEiiIlvCHibyiFFuVRyiYnJDuU6P%2FMRStmrI90cEM%2FepZdR9nJOu9E6px6SuPRgrMlEWrcZA0xlvj37zFA658gGYHVeTLIp905mCf1VTOvzU0SfbH1N4ZDZ5OAncRE%3D&nonce=deK2VwAAAAAuETJontBHQg%3D%3D", "Referer=http://stackoverflow.com/", ENDITEM, 
		"Url=http://mathoverflow.net/users/login/universal.gif?authToken=m9VrzM0aR0Lagu82ahNpj5oiojzrvDF6Mf8j9zKjuw4gXGcvZTarv8VOHRzANQb3E%2FP%2FLy3l5SnN%2BUwDjCoblQMkYBgxd9qsRqSTnO7E8X2TZDa%2BBXIAlTmkr76yLlJtvB%2Fg1oW7UvMXKXOolscFHYXgPiGNe2YfRRDwp8O3vRpyfdVZeoD8g5hwfN6IMqjvZw9tXKsUdL7i7pI%2FrrT8pzrKAApZs4rBZ7nOClhU5zqq3PQHChTIYKhb5TjJGfFycpF96mjHUuu3XV1D9%2BksofSG7%2B9y5kZ7LZThqy23mv8%3D&nonce=deK2VwAAAACJdMSMWRkGtQ%3D%3D", "Referer=http://stackoverflow.com/", ENDITEM, 
		LAST);

	lr_think_time(7);

	web_url("b_3",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603316552&ns_c=UTF-8&cv=3.1&c8=Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2F%23&c9=",
		"Resource=0",
		"Referer=http://stackoverflow.com/",
		"Snapshot=t16.inf",
		"Mode=HTML",
		LAST);

	web_custom_request("event_4", 
		"URL=http://stackoverflow.com/gps/event", 
		"Method=POST", 
		"Resource=0", 
		"Referer=http://stackoverflow.com/", 
		"Snapshot=t17.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=[{\"evt\":\"docs.hero.show\",\"properties\":{\"location\":1},\"now\":1471603317220}]", 
		LAST);

	web_custom_request("request", 
		"URL=http://stackoverflow.com/users/login/universal/request", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=http://stackoverflow.com/", 
		"Snapshot=t18.inf", 
		"Mode=HTML", 
		"EncType=", 
		LAST);

	web_custom_request("event_5", 
		"URL=http://stackoverflow.com/gps/event", 
		"Method=POST", 
		"Resource=0", 
		"Referer=http://stackoverflow.com/", 
		"Snapshot=t19.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=[{\"evt\":\"profile_summary.click\",\"properties\":{},\"now\":1471603324130}]", 
		LAST);

	web_url("sreejith-s-s", 
		"URL=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/", 
		"Snapshot=t20.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://cdn.sstatic.net/Img/user-profile-sprite.svg?v=8cd8def8f520", "Referer=http://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM, 
		"Url=http://cdn.sstatic.net/img/user-profile-sprite.svg?v=8cd8def8f520", "Referer=http://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM, 
		"Url=http://pixel.quantserve.com/pixel;r=1283065221;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603325075;tzo=420;ref=http%3A%2F%2Fstackoverflow.com%2F;url=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s;ogl="
		"type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.User%20Sreejith%20S%20S%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2Fusers%2F3489248%2Fsreejith-s-s", ENDITEM, 
		LAST);

	web_url("b_4",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603325120&ns_c=UTF-8&cv=3.1&c8=User%20Sreejith%20S%20S%20-%20Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s&c9=http%3A%2F%2Fstackoverflow.com%2F",
		"Resource=0",
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s",
		"Snapshot=t21.inf",
		"Mode=HTML",
		LAST);

	lr_think_time(51);

	web_url("soap-fault-response-also-showing-the-request-in-the-soap-body", 
		"URL=http://stackoverflow.com/questions/30082956/soap-fault-response-also-showing-the-request-in-the-soap-body", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Snapshot=t22.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://engine.adzerk.net/ados?t=1471603383550&request={%22Placements%22:[{%22A%22:22,%22S%22:8277,%22D%22:%22adzerk1656503156%22,%22AT%22:4,%22Z%22:[43]},{%22A%22:22,%22S%22:8277,%22D%22:%22adzerk1412682749%22,%22ATA%22:[5,17,2221],%22Z%22:[45]}],%22Keywords%22:%22java%2Cweb-services%2Cjava-ee%2Csoap%2Csoapfault%2Cx-user-registered%22,%22Referrer%22:%22http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s%22,%22IsAsync%22:true}", ENDITEM, 
		"Url=http://cdn.sstatic.net/Js/post-validation.en.js?v=ee34c5cc4547", ENDITEM, 
		"Url=http://cdn.sstatic.net/Js/snippet-javascript.en.js?v=4a15ea92a14d", ENDITEM, 
		"Url=http://cdn.sstatic.net/Js/external-editor.en.js?v=34f78799ad2d", ENDITEM, 
		"Url=http://pixel.quantserve.com/pixel;r=660108887;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603383741;tzo=420;ref=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s;url=http%3A%2F%2Fstackoverflow.com%2Fquestions%2F30082956%2Fsoap-fault-response-also-showing-the-request-in-the-soap-body;ogl="
		"type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.SOAP%20fault%20response%20also%20showing%20the%20request%20in%20the%20SOAP%20body%2Cdescription.When%20we%20requesting%20the%20SOAP%20web%20service%20with%20wrong%20data%252C%20the%20fault%20message%20is%20co%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2Fquestions%2F30082956%2Fsoap-fault-response-also-showing-the", ENDITEM, 
		"Url=http://cdn.sstatic.net/Js/wmd.en.js?v=d2590f0c8ab0", ENDITEM, 
		"Url=http://static.adzerk.net/Advertisers/5eb9f89867a24cf6b7c53014e3c15bea.png", ENDITEM, 
		"Url=http://engine.adzerk.net/i.gif?e="
		"eyJhdiI6NDE0LCJhdCI6NCwiYnQiOjAsImNtIjo0MDQyODMsImNoIjoxMTc4LCJjayI6e30sImNyIjoxNDM0MzE1LCJkaSI6IjE2MmUzNGM3Y2U5MzRlYWQ4YTZiNjE3NzBkZjY5MzgxIiwiZG0iOjEsImZjIjoxNjQ5MzM1LCJmbCI6MTQ0ODM0MiwiaXAiOiIxOTQuMjEzLjExOS41Iiwia3ciOiJqYXZhLHdlYi1zZXJ2aWNlcyxqYXZhLWVlLHNvYXAsc29hcGZhdWx0LHgtdXNlci1yZWdpc3RlcmVkIiwibnciOjIyLCJwYyI6MCwiZWMiOjAsInByIjoxNjA0LCJydCI6MSwicmYiOiJodHRwOi8vc3RhY2tvdmVyZmxvdy5jb20vdXNlcnMvMzQ4OTI0OC9zcmVlaml0aC1zLXMiLCJzdCI6ODI3NywidWsiOiJ1ZTEtZWM0NmFiZWVlM2UxNGE2NGFjMjJlMTJlZGZhY2E0NT"
		"kiLCJ6biI6NDMsInRzIjoxNDcxNjAzMzg0MDc3LCJiZiI6dHJ1ZSwicG4iOiJhZHplcmsxNjU2NTAzMTU2IiwiZnEiOjB9&s=4dwwR7PMKv8dP5DklSo_r3DtwO0", ENDITEM, 
		"Url=http://engine.adzerk.net/i.gif?e="
		"eyJhdiI6NDE0LCJhdCI6NSwiYnQiOjAsImNtIjo5MjEsImNoIjoxMTc4LCJjayI6e30sImNyIjoyNjg4LCJkaSI6IjM5YjMxOWE5ZTdjYzQxOWQ5NjUwNGFhZjE4ZWNiNzlmIiwiZG0iOjEsImZjIjoyNDg1LCJmbCI6MjY2MywiaXAiOiIxOTQuMjEzLjExOS41Iiwia3ciOiJqYXZhLHdlYi1zZXJ2aWNlcyxqYXZhLWVlLHNvYXAsc29hcGZhdWx0LHgtdXNlci1yZWdpc3RlcmVkIiwibnciOjIyLCJwYyI6MCwiZWMiOjAsInByIjo2MTczNywicnQiOjEsInJmIjoiaHR0cDovL3N0YWNrb3ZlcmZsb3cuY29tL3VzZXJzLzM0ODkyNDgvc3JlZWppdGgtcy1zIiwic3QiOjgyNzcsInVrIjoidWUxLWVjNDZhYmVlZTNlMTRhNjRhYzIyZTEyZWRmYWNhNDU5Iiwiem4iOjQ1LC"
		"J0cyI6MTQ3MTYwMzM4NDA3OSwiYmYiOnRydWUsInBuIjoiYWR6ZXJrMTQxMjY4Mjc0OSIsImZxIjowfQ&s=d3zW-7F2spy4VWxBQVpSCq8yymk", ENDITEM, 
		"Url=http://clc.stackoverflow.com/p.js?zones=1%3Dhireme&ac=4266174&tags=java%3Bweb-services%3Bjava-ee%3Bsoap%3Bsoapfault&host=stackoverflow.com&lw=992&bw=1920&az=1", ENDITEM, 
		"Url=http://cdn.sstatic.net/clc/styles/clc/jobs-multi.min.css?v=a28a58104dce", ENDITEM, 
		"Url=http://clc.stackoverflow.com/soi.gif?an=Y2NiYGy-NFP2xGUPhn0SjgysjAye6kysnAyMDOzMDAwMLO-2MjHYNt9am7PipT0LWJxRDkiwMIAkGYHEg6tMDIlr-Ld9dH-LqcAISFxPY2ZQemtw_2rGa3tmNAV7jJgZNpSITil79gZDTkkbbDkrQwATyA5WhigmkFEgPkgbiC_8K9n58mHtiK44AA&at=0&pt=524", ENDITEM, 
		LAST);

	web_url("b_5",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603383807&ns_c=UTF-8&cv=3.1&c8=java%20-%20SOAP%20fault%20response%20also%20showing%20the%20request%20in%20the%20SOAP%20body%20-%20Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2Fquestions%2F30082956%2Fsoap-fault-response-also-showing-the-request-in-the-soap-body&c9=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s",
		"Resource=0",
		"Referer=http://stackoverflow.com/questions/30082956/soap-fault-response-also-showing-the-request-in-the-soap-body",
		"Snapshot=t23.inf",
		"Mode=HTML",
		LAST);

	web_url("0937", 
		"URL=http://stackoverflow.com/posts/30082956/ivc/0937?_=1471603383921", 
		"Resource=0", 
		"Referer=http://stackoverflow.com/questions/30082956/soap-fault-response-also-showing-the-request-in-the-soap-body", 
		"Snapshot=t24.inf", 
		"Mode=HTML", 
		LAST);

	web_custom_request("event_6", 
		"URL=http://stackoverflow.com/gps/event", 
		"Method=POST", 
		"Resource=0", 
		"Referer=http://stackoverflow.com/questions/30082956/soap-fault-response-also-showing-the-request-in-the-soap-body", 
		"Snapshot=t25.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=[{\"evt\":\"docs.hero.show\",\"properties\":{\"location\":2},\"now\":1471603384302}]", 
		EXTRARES, 
		"Url=http://cdn.sstatic.net/clc/img/tag-themed/java-header.png?v=0cbd6b4ab039", "Referer=http://cdn.sstatic.net/clc/styles/clc/jobs-multi.min.css?v=a28a58104dce", ENDITEM, 
		"Url=http://cdn.sstatic.net/clc/img/jobs/ico-location-gray.svg?v=0cbd6b4ab039", "Referer=http://cdn.sstatic.net/clc/styles/clc/jobs-multi.min.css?v=a28a58104dce", ENDITEM, 
		"Url=http://cdn.sstatic.net/clc/img/jobs/ico-dismiss.svg?v=0cbd6b4ab039", "Referer=http://cdn.sstatic.net/clc/styles/clc/jobs-multi.min.css?v=a28a58104dce", ENDITEM, 
		LAST);

	lr_think_time(4);

	web_url("subscriber-info", 
		"URL=http://stackoverflow.com/tags/java-ee/subscriber-info?_=1471603390021", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/questions/30082956/soap-fault-response-also-showing-the-request-in-the-soap-body", 
		"Snapshot=t26.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=https://adzerk-www.s3.amazonaws.com/customAdTypes/thumb_sprites.png", "Referer=http://static.adzerk.net/Extensions/adFeedback.css", ENDITEM, 
		LAST);

	web_url("edit", 
		"URL=http://stackoverflow.com/posts/30082956/edit", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/questions/30082956/soap-fault-response-also-showing-the-request-in-the-soap-body", 
		"Snapshot=t27.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://cdn.sstatic.net/Js/tageditornew.en.js?v=b4040cdd8444", ENDITEM, 
		"Url=http://pixel.quantserve.com/pixel;r=1793730201;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603399262;tzo=420;ref=http%3A%2F%2Fstackoverflow.com%2Fquestions%2F30082956%2Fsoap-fault-response-also-showing-the-request-in-the-soap-body;url=http%3A%2F%2Fstackoverflow.com%2Fposts%2F30082956%2Fedit;ogl="
		"type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.Edit%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2Fposts%2F30082956%2Fedit", ENDITEM, 
		"Url=/content/img/progress-dots.gif", ENDITEM, 
		"Url=../new-tags-warning?tags=java+web-services+java-ee+soap+soapfault+&_=1471603401459", ENDITEM, 
		LAST);

	web_custom_request("query_2", 
		"URL=https://clients1.google.com/tbproxy/af/query?client=Google%20Chrome", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/proto", 
		"Referer=", 
		"Snapshot=t28.inf", 
		"Mode=HTML", 
		"EncType=text/proto", 
		"BodyBinary=\n\\x176.1.1715.1442/en (GGLL)\\x13\\x19r\\xCB\\x10*\\x94\\xF5[V#-\\xA3_TU$#-\\x17\\xEA\\xFBH$#-\\xA3\\x1B\\x9D\\xCA$#-\\xFC\\xF8V\\xD6$#-P\\x85N\\xA7$\\x14", 
		LAST);

	lr_think_time(6);

	web_url("b_6",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603399330&ns_c=UTF-8&cv=3.1&c8=Edit%20-%20Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2Fposts%2F30082956%2Fedit&c9=http%3A%2F%2Fstackoverflow.com%2Fquestions%2F30082956%2Fsoap-fault-response-also-showing-the-request-in-the-soap-body",
		"Resource=0",
		"Referer=http://stackoverflow.com/posts/30082956/edit",
		"Snapshot=t29.inf",
		"Mode=HTML",
		EXTRARES,
		"URL=http://cdn.sstatic.net/Sites/stackoverflow/img/wmd-buttons.svg?v=063c0288e422", "Referer=http://cdn.sstatic.net/Sites/stackoverflow/all.css?v=3fc461deec5c", ENDITEM,
		LAST);

	web_url("markdown-help", 
		"URL=http://stackoverflow.com/posts/markdown-help?postfix=-30082956&_=1471603399763", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/posts/30082956/edit", 
		"Snapshot=t30.inf", 
		"Mode=HTML", 
		LAST);

	web_submit_data("de1eb3e5-2e43-4e47-813f-5039b7036f81",
		"Action=http://stackoverflow.com/posts/30082956/edit-submit/de1eb3e5-2e43-4e47-813f-5039b7036f81",
		"Method=POST",
		"RecContentType=application/json",
		"Referer=http://stackoverflow.com/posts/30082956/edit",
		"Snapshot=t31.inf",
		"Mode=HTML",
		ITEMDATA,
		"Name=is-current", "Value=true", ENDITEM,
		"Name=warntags", "Value=", ENDITEM,
		"Name=title", "Value=SOAP fault response also showing the request in the SOAP body", ENDITEM,
		"Name=post-text", "Value=When we requesting the SOAP web service with wrong data, the fault message is coming properly, but along with that the requested data are also coming under the SOAP body, How can I make only fault section coming under the SOAP body?  I do not want the request data in the SOAP body along withe fault details", ENDITEM,
		"Name=fkey", "Value={fkey}", ENDITEM,
		"Name=author", "Value=", ENDITEM,
		"Name=tagnames", "Value=java web-services java-ee soap soapfault ", ENDITEM,
		"Name=edit-comment", "Value=", ENDITEM,
		LAST);

	web_url("soap-fault-response-also-showing-the-request-in-the-soap-body_2", 
		"URL=http://stackoverflow.com/questions/30082956/soap-fault-response-also-showing-the-request-in-the-soap-body", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/posts/30082956/edit", 
		"Snapshot=t32.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://pixel.quantserve.com/pixel;r=1620368899;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603402403;tzo=420;ref=http%3A%2F%2Fstackoverflow.com%2Fposts%2F30082956%2Fedit;url=http%3A%2F%2Fstackoverflow.com%2Fquestions%2F30082956%2Fsoap-fault-response-also-showing-the-request-in-the-soap-body;ogl="
		"type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.SOAP%20fault%20response%20also%20showing%20the%20request%20in%20the%20SOAP%20body%2Cdescription.When%20we%20requesting%20the%20SOAP%20web%20service%20with%20wrong%20data%252C%20the%20fault%20message%20is%20co%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2Fquestions%2F30082956%2Fsoap-fault-response-also-showing-the", ENDITEM, 
		"Url=http://engine.adzerk.net/ados?t=1471603402366&request={%22Placements%22:[{%22A%22:22,%22S%22:8277,%22D%22:%22adzerk1266815129%22,%22AT%22:4,%22Z%22:[43]},{%22A%22:22,%22S%22:8277,%22D%22:%22adzerk637604316%22,%22ATA%22:[5,17,2221],%22Z%22:[45]}],%22Keywords%22:%22java%2Cweb-services%2Cjava-ee%2Csoap%2Csoapfault%2Cx-user-registered%22,%22Referrer%22:%22http%3A%2F%2Fstackoverflow.com%2Fposts%2F30082956%2Fedit%22,%22IsAsync%22:true}", ENDITEM, 
		"Url=http://static.adzerk.net/Advertisers/6035965a800b4a1aab784905acc5af9b.png", ENDITEM, 
		"Url=http://static.adzerk.net/Advertisers/421addf39e454d6b88e1ee519e71fae2.png", ENDITEM, 
		"Url=http://clc.stackoverflow.com/p.js?zones=2%3Dhireme&ac=4266174&tags=java%3Bweb-services%3Bjava-ee%3Bsoap%3Bsoapfault&host=stackoverflow.com&lw=666&bw=1920&az=1", ENDITEM, 
		"Url=http://engine.adzerk.net/i.gif?e="
		"eyJhdiI6NzA1MzgsImF0Ijo1LCJidCI6MCwiY20iOjQzMDUzNCwiY2giOjExNzgsImNrIjp7fSwiY3IiOjE1MDUzNDYsImRpIjoiMGZkY2M0Nzc0MWVlNDZkYjk4NWRmNjJlODlkNzBjNDkiLCJkbSI6MSwiZmMiOjE3NTI1NjAsImZsIjoxNzUwNzgyLCJpcCI6IjE5NC4yMTMuMTE5LjUiLCJrdyI6ImphdmEsd2ViLXNlcnZpY2VzLGphdmEtZWUsc29hcCxzb2FwZmF1bHQseC11c2VyLXJlZ2lzdGVyZWQiLCJtayI6ImphdmEsamF2YS1lZSIsIm53IjoyMiwicGMiOjEyLjEsImVjIjoxMi4xLCJwciI6NzY1LCJydCI6MiwicmYiOiJodHRwOi8vc3RhY2tvdmVyZmxvdy5jb20vcG9zdHMvMzAwODI5NTYvZWRpdCIsInN0Ijo4Mjc3LCJ1ayI6InVlMS1lYzQ2YWJlZWUzZT"
		"E0YTY0YWMyMmUxMmVkZmFjYTQ1OSIsInpuIjo0NSwidHMiOjE0NzE2MDM0MDI1NDksImJmIjp0cnVlLCJwbiI6ImFkemVyazYzNzYwNDMxNiIsImZxIjowfQ&s=7NKEjYnCukbUAe_mBfi7U-ttD88", ENDITEM, 
		"Url=http://engine.adzerk.net/i.gif?e="
		"eyJhdiI6NDE0LCJhdCI6NCwiYnQiOjAsImNtIjo0MDQyODMsImNoIjoxMTc4LCJjayI6e30sImNyIjoxNDM0Mjg1LCJkaSI6ImYxMjlhYzI1ZjAwMTRkYmVhZGRkM2I3Y2Q2N2NlNzY5IiwiZG0iOjEsImZjIjoxNjQ5Mjc5LCJmbCI6MTQ0ODM0MywiaXAiOiIxOTQuMjEzLjExOS41Iiwia3ciOiJqYXZhLHdlYi1zZXJ2aWNlcyxqYXZhLWVlLHNvYXAsc29hcGZhdWx0LHgtdXNlci1yZWdpc3RlcmVkIiwibnciOjIyLCJwYyI6MCwiZWMiOjAsInByIjoxNTY4LCJydCI6MSwicmYiOiJodHRwOi8vc3RhY2tvdmVyZmxvdy5jb20vcG9zdHMvMzAwODI5NTYvZWRpdCIsInN0Ijo4Mjc3LCJ1ayI6InVlMS1lYzQ2YWJlZWUzZTE0YTY0YWMyMmUxMmVkZmFjYTQ1OSIsInpuIj"
		"o0MywidHMiOjE0NzE2MDM0MDI1NDYsImJmIjp0cnVlLCJwbiI6ImFkemVyazEyNjY4MTUxMjkiLCJmcSI6MH0&s=47-8tFlAQez-clGnLbeEZqBt7l4", ENDITEM, 
		"Url=http://clc.stackoverflow.com/soi.gif?an=Y2NisC1ft0T2xGUPhn0SjgysjAxnjZhYORmYGNiZGRgYmC46MDP8u68pevDXS3tmsDijHAMjAwtQjuHBVSaGM8UFU-4ve23PgibHYgQkhLTB-lkZAphBakF0XI_2O2-ZqiuVBQA&at=0&pt=388", ENDITEM, 
		LAST);

	web_url("b_7",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603402456&ns_c=UTF-8&cv=3.1&c8=java%20-%20SOAP%20fault%20response%20also%20showing%20the%20request%20in%20the%20SOAP%20body%20-%20Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2Fquestions%2F30082956%2Fsoap-fault-response-also-showing-the-request-in-the-soap-body&c9=http%3A%2F%2Fstackoverflow.com%2Fposts%2F30082956%2Fedit",
		"Resource=0",
		"Referer=http://stackoverflow.com/questions/30082956/soap-fault-response-also-showing-the-request-in-the-soap-body",
		"Snapshot=t33.inf",
		"Mode=HTML",
		LAST);

	web_url("0937_2", 
		"URL=http://stackoverflow.com/posts/30082956/ivc/0937?_=1471603402590", 
		"Resource=0", 
		"Referer=http://stackoverflow.com/questions/30082956/soap-fault-response-also-showing-the-request-in-the-soap-body", 
		"Snapshot=t34.inf", 
		"Mode=HTML", 
		LAST);

	web_custom_request("event_7", 
		"URL=http://stackoverflow.com/gps/event", 
		"Method=POST", 
		"Resource=0", 
		"Referer=http://stackoverflow.com/questions/30082956/soap-fault-response-also-showing-the-request-in-the-soap-body", 
		"Snapshot=t35.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=[{\"evt\":\"docs.hero.show\",\"properties\":{\"location\":2},\"now\":1471603402623}]", 
		LAST);

	lr_think_time(5);

	web_url("documentation", 
		"URL=http://stackoverflow.com/documentation", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/questions/30082956/soap-fault-response-also-showing-the-request-in-the-soap-body", 
		"Snapshot=t36.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://cdn.sstatic.net/img/documentation/doc-sprites.svg?v=3df80589e815", "Referer=http://cdn.sstatic.net/Shared/Docs/docs.css?v=e9a4bfd9c7f2", ENDITEM, 
		"Url=http://pixel.quantserve.com/pixel;r=1888090182;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603411223;tzo=420;ref=http%3A%2F%2Fstackoverflow.com%2Fquestions%2F30082956%2Fsoap-fault-response-also-showing-the-request-in-the-soap-body;url=http%3A%2F%2Fstackoverflow.com%2Fdocumentation;ogl="
		"type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.Documentation%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2Fdocumentation", ENDITEM, 
		LAST);

	web_url("b_8",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603411262&ns_c=UTF-8&cv=3.1&c8=Documentation%20-%20Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2Fdocumentation&c9=http%3A%2F%2Fstackoverflow.com%2Fquestions%2F30082956%2Fsoap-fault-response-also-showing-the-request-in-the-soap-body",
		"Resource=0",
		"Referer=http://stackoverflow.com/documentation",
		"Snapshot=t37.inf",
		"Mode=HTML",
		LAST);

	web_submit_data("submit",
		"Action=http://stackoverflow.com/documentation/filter/submit",
		"Method=POST",
		"RecContentType=text/html",
		"Referer=http://stackoverflow.com/documentation",
		"Snapshot=t38.inf",
		"Mode=HTML",
		ITEMDATA,
		"Name=filter", "Value=java", ENDITEM,
		"Name=fkey", "Value={fkey}", ENDITEM,
		"Name=tab", "Value=popular", ENDITEM,
		LAST);

	lr_think_time(11);

	web_url("users", 
		"URL=http://stackoverflow.com/users", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/documentation", 
		"Snapshot=t39.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://pixel.quantserve.com/pixel;r=999724289;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603433880;tzo=420;ref=http%3A%2F%2Fstackoverflow.com%2Fdocumentation;url=http%3A%2F%2Fstackoverflow.com%2Fusers;ogl="
		"type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.Users%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2Fusers", ENDITEM, 
		LAST);

	web_url("b_9",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603433931&ns_c=UTF-8&cv=3.1&c8=Users%20-%20Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2Fusers&c9=http%3A%2F%2Fstackoverflow.com%2Fdocumentation",
		"Resource=0",
		"Referer=http://stackoverflow.com/users",
		"Snapshot=t40.inf",
		"Mode=HTML",
		LAST);

	lr_think_time(6);

	web_url("filter", 
		"URL=http://stackoverflow.com/users/filter?search=sreejith&filter=Week&tab=Reputation&_=1471603440968", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/users", 
		"Snapshot=t41.inf", 
		"Mode=HTML", 
		LAST);

	web_url("filter_2", 
		"URL=http://stackoverflow.com/users/filter?search=sreejith+sree&filter=Week&tab=Reputation&_=1471603444723", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/users", 
		"Snapshot=t42.inf", 
		"Mode=HTML", 
		LAST);

	web_url("filter_3", 
		"URL=http://stackoverflow.com/users/filter?search=sreejith&filter=Week&tab=Reputation&_=1471603450041", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/users", 
		"Snapshot=t43.inf", 
		"Mode=HTML", 
		LAST);

	web_add_cookie("NID=80=vTnbLohjfKOhtCDSD3r2kCtWH6blH_DdPofCcb9YGXqdKJvjxLtSBpcQ4l-MhnhyuddeV1r1ySB7X6DamzLb-G9xNw6vw3eYbSjFjgcYO2nDE2MRLpoLatv2OWY0t7rG; DOMAIN=safebrowsing.google.com");

	web_custom_request("downloads", 
		"URL=https://safebrowsing.google.com/safebrowsing/downloads?client=googlechrome&appver=52.0.2743.116&pver=3.0&key=AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw&ext=1", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/vnd.google.safebrowsing-update", 
		"Referer=", 
		"Snapshot=t44.inf", 
		"Mode=HTML", 
		"EncType=text/plain", 
		"Body=goog-malware-shavar;a:239855-247707:s:235300-243065\ngoog-phish-shavar;a:447331-455167:s:267624-268536,268538-275445,275447-277769,277771-280327\ngoog-badbinurl-shavar;a:108165-110366:s:110796-111859,111861-112233,112235-112345,112347-112797\ngoog-csdwhite-sha256;a:3-84:s:1-5\ngoog-downloadwhite-digest256;a:5-83:s:2-7,10-56\ngoog-badcrxids-digestvar;a:2-1098:s:1,3-120\ngoog-badip-digest256;a:2798-2803\ngoog-unwanted-shavar;a:60395-76375:s:53420-53422,53424-53425,53428-53430,53432-53433,"
		"53435-53443,53446-53451,53455-53457,53460,53462-53465,53467-53468,53471,53474,53476-53477,53479,53481-53482,53484-53485,53487-53506,53509-53511,53513-53514,53516-53525,53527-53529,53531-53532,53534-53540,53542,53544,53547-53549,53551-53558,53560-53565,53567-53581,53583-53584,53587-53594,53596-53618,53620-53644,53646-53688,53690-53702,53704-53724,53726-53740,53742-53751,53753-53776,53778-53791,53793-53800,53802-53808,53810-53816,53819-53829,53831-53832,53834-53837,53839-53841,53843-53849,"
		"53851-53860,53862-53886,53888,53890-53895,53898-53913,53915-53918,53920-53926,53929-53933,53935-53954,53956-53958,53960-53964,53966-53983,53985-53987,53989,53992-54002,54006,54015-54019,54021-54022,54024-54046,54048,54050-54055,54058-54060,54062-54065,54067-54073,54075-54124,54126-54137,54139-54144,54146-54157,54159-54160,54162-54163,54165-54168,54170-54195,54197-54208,54210-54279,54281-54303,54305-54351,54353-54388,54390-54394,54396-54397,54399-54406,54408-54413,54415-54449,54451-54464,"
		"54466-54483,54485,54487-54492,54494-54497,54499-54528,54530-54533,54535-54536,54538,54540-54559,54561-54562,54564-54649,54651-54664,54666-54673,54675-54682,54684-54704,54706-54727,54729-54738,54740-54745,54747-54749,54751-54754,54756-54774,54776-54782,54786-54787,54789-54792,54795-54818,54820-54831,54833-54840,54843-54860,54862-54864,54867,54869-54885,54887,54889,54891-54898,54900,54903,54905-54914,54916-54925,54927-54928,54930,54932-54936,54938-54940,54942-54945,54947,54949,54951-54977,"
		"54979-54986,54988-55035,55037-55044,55046-55048,55052-55055,55057-55066,55068-55076,55078-55081,55084-55087,55089-55110,55112-55163,55165-55192,55194-55205,55207-55231,55233-55237,55239-55259,55261-55267,55269-55270,55273-55275,55277-55278,55280,55282-55285,55287-55290,55292-55296,55299-55308,55310-55322,55324-55340,55342-55367,55369,55371-55374,55377-55378,55380-55383,55385-55389,55391-55401,55404-55421,55423-55443,55445-55469,55471-55473,55475-55478,55480-55482,55484-55493,55495-55496,"
		"55498-55499,55501-55505,55508-55511,55513-55518,55520-55548,55550-55563,55565-55572,55574,55576,55578-55607,55609-55621,55623-55637,55639-55640,55642-55661,55663-55705,55707,55709,55711-55713,55715-55732,55734-55744,55746,55748-55760,55762-55775,55777-55796,55799-55837,55839-55842,55844-55850,55852-55853,55855-55860,55862-55863,55865-55872,55874,55876-55877,55879-55907,55909-55913,55915-55931,55933-55941,55943-55963,55965-55968,55978,55981-55982,55984-55989,55992-55994,55996,55999-56004,56006,"
		"56009-56013,56015-56020,56022,56024-56030,56032-56033,56035-56058,56060-56072,56074-56081,56084-56086,56089,56091,56093-56100,56102-56105,56107-56113,56115-56117,56119-56225,56227-56275,56277-56308,56310,56312-56314,56316-56317,56319-56320,56322-56323,56325-56327,56329-56332,56335-56373,56375-56386,56389-56404,56406,56408-56418,56420-56422,56424-56425,56427-56436,56438-56439,56441,56443,56445,56447-56448,56451-56455,56457-56459,56461-56462,56464-56465,56467-56472,56474-56488,56490,56492-56494,"
		"56496,56498,56500-56504,56506-56538,56540-56554,56556-56568,56570-56587,56589-56598,56600-56647,56649-56665,56667-56669,56671-56695,56697-56781,56783-56786,56788,56790-56798,56800,56802-56817,56819-56823,56825-56828,56830-56857,56859-56861,56863-56871,56873-56896,56898-56900,56903,56905,56907-56913,56915-56916,56918-56922,56924-56925,56927-56930,56932,56934-56939,56942,56944-56964,56966-56971,56973-56975,56977-56982,56984-57003,57005-57031,57033-57040,57042-57043,57045-57061,57063-57068,"
		"57071-57092,57094-57151,57153-57158,57160-57161,57163-57166,57168,57170-57189,57191-57200,57202-57203,57205-57263,57265-57286,57288-57290,57292,57294-57297,57300-57301,57303-57305,57307-57319,57324-57327,57329-57333,57335-57336,57338-57350,57352-57355,57357-57377,57379-57415,57417-57422,57424-57429,57431-57432,57434-57435,57437-57446,57448-57449,57451-57462,57464-57502,57504-57512,57514-57526,57528-57531,57533-57541,57543,57545-57555,57557-57562,57564-57580,57582-57597,57599-57686,57688-57710,"
		"57712-57714,57716-57960,57962-58038,58040-58254,58256-58330,58332-58470,58472-58474,58476-58531,58533-58727,58729-58812,58814-59062,59064-59073,59075-59165,59167-59171,59173-59240,59242-59286,59288-59378,59380-59394,59396,59398-59449,59451-59598,59600-59655,59657-59848,59850-59925,59927-59929,59931-60222,60224-60244,60246-60324,60326-60413,60415-60437,60439-60492,60494-60497,60499-60594,60596-60630,60632-60800,60802-60951,60953-60982,60984-60998,61000-61001,61003-61050,61052-61066,61068-61100,"
		"61102-61111,61113-61156,61158-61223,61225-61359,61361-61425,61427-61677,61679-61817,61819-61861,61863-62130,62132-62179,62181-62422,62424-62478,62480-62507,62509-62519,62521-62559,62561-62689,62691-62755,62757-62758,62760-62999,63001-63051,63053-63135,63137-63233,63235-63252,63254-63752,63754-63887,63889-64372,64374-64394,64396-64541,64543-64572,64574-64704,64706-65061,65063-65433,65435-65534,65536-65601,65603-65646,65648-65938,65940-68522,68524-71790\ngoog-whitemodule-digest256;a:1-38\n"
		"goog-badresource-shavar;a:1-6\n", 
		LAST);

	web_add_cookie("NID=80=vTnbLohjfKOhtCDSD3r2kCtWH6blH_DdPofCcb9YGXqdKJvjxLtSBpcQ4l-MhnhyuddeV1r1ySB7X6DamzLb-G9xNw6vw3eYbSjFjgcYO2nDE2MRLpoLatv2OWY0t7rG; DOMAIN=safebrowsing-cache.google.com");

	web_url("filter_4", 
		"URL=http://stackoverflow.com/users/filter?search=sreejith+s+s&filter=Week&tab=Reputation&_=1471603451149", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/users", 
		"Snapshot=t45.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=https://safebrowsing-cache.google.com/safebrowsing/rd/ChVnb29nLWJhZGJpbnVybC1zaGF2YXI4AUACSgwIARCe8QYYpfEGIAFKDAgAEJ_eBhil3gYgAQ", "Referer=", ENDITEM, 
		LAST);

	web_link("Sreejith S S", 
		"Text=Sreejith S S", 
		"Snapshot=t46.inf", 
		EXTRARES, 
		"Url=http://pixel.quantserve.com/pixel;r=523283525;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603455179;tzo=420;ref=http%3A%2F%2Fstackoverflow.com%2Fusers;url=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s;ogl="
		"type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.User%20Sreejith%20S%20S%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2Fusers%2F3489248%2Fsreejith-s-s", ENDITEM, 
		LAST);

	web_url("b_10",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603455368&ns_c=UTF-8&cv=3.1&c8=User%20Sreejith%20S%20S%20-%20Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s&c9=http%3A%2F%2Fstackoverflow.com%2Fusers",
		"Resource=0",
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s",
		"Snapshot=t47.inf",
		"Mode=HTML",
		LAST);

	web_url("badges", 
		"URL=http://stackoverflow.com/help/badges", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Snapshot=t48.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://pixel.quantserve.com/pixel;r=1237801492;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603460529;tzo=420;ref=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s;url=http%3A%2F%2Fstackoverflow.com%2Fhelp%2Fbadges;ogl="
		"type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.Badges%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2Fhelp%2Fbadges", ENDITEM, 
		LAST);

	lr_think_time(4);

	web_url("b_11",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603460903&ns_c=UTF-8&cv=3.1&c8=Badges%20-%20Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2Fhelp%2Fbadges&c9=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s",
		"Resource=0",
		"Referer=http://stackoverflow.com/help/badges",
		"Snapshot=t49.inf",
		"Mode=HTML",
		LAST);

	lr_think_time(9);

	web_custom_request("event_8", 
		"URL=http://stackoverflow.com/gps/event", 
		"Method=POST", 
		"Resource=0", 
		"Referer=http://stackoverflow.com/help/badges", 
		"Snapshot=t50.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=[{\"evt\":\"help_popup.click\",\"properties\":{\"item_type\":6},\"now\":1471603470102}]", 
		LAST);

	web_url("about", 
		"URL=http://stackoverflow.com/company/about", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/help/badges", 
		"Snapshot=t51.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://pixel.quantserve.com/pixel;r=1074270483;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603471713;tzo=420;ref=http%3A%2F%2Fstackoverflow.com%2Fhelp%2Fbadges;url=http%3A%2F%2Fstackoverflow.com%2Fcompany%2Fabout;ogl="
		"type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.About%20-%20Stack%20Overflow%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2Fcompany%2Fabout", ENDITEM, 
		LAST);

	web_url("b_12",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603471762&ns_c=UTF-8&cv=3.1&c8=About%20-%20Stack%20Overflow%20-%20Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2Fcompany%2Fabout&c9=http%3A%2F%2Fstackoverflow.com%2Fhelp%2Fbadges",
		"Resource=0",
		"Referer=http://stackoverflow.com/company/about",
		"Snapshot=t52.inf",
		"Mode=HTML",
		LAST);

	web_url("site-list", 
		"URL=http://stackoverflow.com/topbar/site-switcher/site-list?_=1471603474486", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/company/about", 
		"Snapshot=t53.inf", 
		"Mode=HTML", 
		LAST);

	web_custom_request("event_9", 
		"URL=http://stackoverflow.com/gps/event", 
		"Method=POST", 
		"Resource=0", 
		"Referer=http://stackoverflow.com/company/about", 
		"Snapshot=t54.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=[{\"evt\":\"site_switcher.show\",\"properties\":{},\"now\":1471603474495}]", 
		LAST);

	web_custom_request("event_10", 
		"URL=http://stackoverflow.com/gps/event", 
		"Method=POST", 
		"Resource=0", 
		"Referer=http://stackoverflow.com/company/about", 
		"Snapshot=t55.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=[{\"evt\":\"profile_summary.click\",\"properties\":{},\"now\":1471603477065}]", 
		LAST);

	web_url("sreejith-s-s_2", 
		"URL=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/company/about", 
		"Snapshot=t56.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://pixel.quantserve.com/pixel;r=1110904435;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603477968;tzo=420;ref=http%3A%2F%2Fstackoverflow.com%2Fcompany%2Fabout;url=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s;ogl="
		"type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.User%20Sreejith%20S%20S%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2Fusers%2F3489248%2Fsreejith-s-s", ENDITEM, 
		LAST);

	web_url("b_13",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603478010&ns_c=UTF-8&cv=3.1&c8=User%20Sreejith%20S%20S%20-%20Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s&c9=http%3A%2F%2Fstackoverflow.com%2Fcompany%2Fabout",
		"Resource=0",
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s",
		"Snapshot=t57.inf",
		"Mode=HTML",
		LAST);

/*Correlation comment - Do not change!  Original value='t=pt5cu9yd35jDM9K%2bMZ0JmS9j0PrKB2qB&s=09gLGgVV3o3h5Ruu%2f5wqdAg3X3YKB3iq' Name ='acct' Type ='ResponseBased'*/
	web_reg_save_param_regexp(
		"ParamName=acct",
		"RegExp=acct=(.*?);",
		SEARCH_FILTERS,
		"Scope=Cookies",
		"IgnoreRedirections=No",
		LAST);

	web_custom_request("event_11", 
		"URL=http://stackoverflow.com/gps/event", 
		"Method=POST", 
		"Resource=0", 
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Snapshot=t58.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=[{\"evt\":\"profile_summary.click\",\"properties\":{},\"now\":1471603479242}]", 
		LAST);

	web_url("sreejith-s-s_3", 
		"URL=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Snapshot=t59.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://pixel.quantserve.com/pixel;r=1994918172;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603480112;tzo=420;ref=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s;url=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s;ogl="
		"type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.User%20Sreejith%20S%20S%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2Fusers%2F3489248%2Fsreejith-s-s", ENDITEM, 
		LAST);

	web_url("b_14",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603480161&ns_c=UTF-8&cv=3.1&c8=User%20Sreejith%20S%20S%20-%20Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s&c9=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s",
		"Resource=0",
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s",
		"Snapshot=t60.inf",
		"Mode=HTML",
		LAST);

	web_add_cookie("acct={acct}; DOMAIN=stackoverflow.com");

	web_custom_request("event_12", 
		"URL=http://stackoverflow.com/gps/event", 
		"Method=POST", 
		"Resource=0", 
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Snapshot=t61.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=[{\"evt\":\"profile_summary.click\",\"properties\":{},\"now\":1471603481672}]", 
		LAST);

	web_url("sreejith-s-s_4", 
		"URL=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Snapshot=t62.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://pixel.quantserve.com/pixel;r=638576015;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603482560;tzo=420;ref=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s;url=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s;ogl="
		"type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.User%20Sreejith%20S%20S%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2Fusers%2F3489248%2Fsreejith-s-s", ENDITEM, 
		LAST);

	web_url("b_15",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603482608&ns_c=UTF-8&cv=3.1&c8=User%20Sreejith%20S%20S%20-%20Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s&c9=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s",
		"Resource=0",
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s",
		"Snapshot=t63.inf",
		"Mode=HTML",
		LAST);

	web_url("sreejith-s-s_5", 
		"URL=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Snapshot=t64.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://pixel.quantserve.com/pixel;r=424308682;a=p-c1rF4kxgLUzNc;fpan=0;fpa=P0-81082907-1471603250711;ns=0;ce=1;cm=;je=0;sr=1920x1080x24;enc=n;dst=1;et=1471603485585;tzo=420;ref=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s;url=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s;ogl="
		"type.website%2Cimage.http%3A%2F%2Fcdn%252Esstatic%252Enet%2FSites%2Fstackoverflow%2Fimg%2Fapple-touch-icon%402%252Epng%3Fv%3D73d79a89%2Ctitle.User%20Sreejith%20S%20S%2Cdescription.Q%26A%20for%20professional%20and%20enthusiast%20programmers%2Curl.http%3A%2F%2Fstackoverflow%252Ecom%2Fusers%2F3489248%2Fsreejith-s-s", ENDITEM, 
		LAST);

	web_url("b_16",
		"URL=http://b.scorecardresearch.com/b?c1=2&c2={c2}&ns__t=1471603485627&ns_c=UTF-8&cv=3.1&c8=User%20Sreejith%20S%20S%20-%20Stack%20Overflow&c7=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s&c9=http%3A%2F%2Fstackoverflow.com%2Fusers%2F3489248%2Fsreejith-s-s",
		"Resource=0",
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s",
		"Snapshot=t65.inf",
		"Mode=HTML",
		LAST);

	lr_think_time(6);

	web_url("site-list_2", 
		"URL=http://stackoverflow.com/topbar/site-switcher/site-list?_=1471603489280", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Snapshot=t66.inf", 
		"Mode=HTML", 
		LAST);

	web_custom_request("event_13", 
		"URL=http://stackoverflow.com/gps/event", 
		"Method=POST", 
		"Resource=0", 
		"Referer=http://stackoverflow.com/users/3489248/sreejith-s-s", 
		"Snapshot=t67.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=[{\"evt\":\"site_switcher.show\",\"properties\":{},\"now\":1471603489289}]", 
		LAST);

	return 0;
}