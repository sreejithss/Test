Action()
{

web_reg_save_param("p_companyid", "LB=TEST", "RB=|", LAST);

web_url("www.wikipedia.org", 
        "URL=https://www.wikipedia.org/", 
        "TargetFrame=", 
        "Resource=0", 
        "RecContentType=application/html", 
        "Referer=", 
        "Snapshot=t1.inf", 
        "Mode=HTML", 
        LAST);

}
