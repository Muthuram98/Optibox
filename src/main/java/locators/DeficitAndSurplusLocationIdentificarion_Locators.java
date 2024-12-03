package locators;

public interface DeficitAndSurplusLocationIdentificarion_Locators {

	public static String session_confirmation="Already a valid session is active for this login confirm>//span[contains(text(),'Already a valid session is active for this login')]/following::button[@id='confirm']";
	public static String Username_input="UserName Input field>//input[@id='nfr_login_authname']";
	public static String Password_input="Password Input field>//input[@id='nfr_login_authid']";
	public static String SignIn="Sign In button>//button[@id='nfr_login_btnlogin']";

	public static String Searchbox="Searchbox>//input[@id='nfr_topbar_autocomp_input']";
	public static String Selectdeficit="Selectdeficit>//span[contains(text(),'Deficit and Surplus Location Identification')]";
	public static String New="New Record>//button[@id='DSL-DSL_toolbar-btnTblNew']";
	public static String Globalserach="Globalserach>//button[@id='DSL-DSL_toolbar-btnTblJdlgSearch']";	
	public static String Closetab="Closetab>(//label[text()='Deficit and Surplus Location Identification']/following::a)[3]";
	public static String Close_Mapviewtab="Close_Mapviewtab>(//label[text()='Map View']/following::a)[3]";
	public static String Globalserach_IDInput="Globalserach ID input field>//input[@id='txt_name1']";	 
	public static String Click_Search="Globalserach ID input field>//button[@id='myBtn']";	 
	public static String SelectID="SelectID>(//div[@col-id='C1'])[2]";	
	public static String Editbutton="Editbutton>//button[@id='DSL-DSL_toolbar-btnTblEdit']";
	public static String createnew_confirm_message="Created new confirm message>(//h2[text()='Deficit and Surplus Location Identification']/following::span)[2]";
	public static String createnew_confirm="Created new confirm>//h2[text()='Deficit and Surplus Location Identification']/following::button[text()='Yes']";
	public static String Save="Save>//button[@id='DSL-DSL_toolbar-btnsave']";	
	public static String Cancel="Cancel>//button[@id='DSL-DSL_toolbar-btnTblCancel']";	
	public static String Print="Print>//button[@id='DSL-DSL_toolbar-btnTblPrint']";	
	public static String Saveas="Saveas>//button[@id='DSL-DSL_toolbar-btnTblSaveas']";	
	public static String Delete="Delete>//button[@id='DSL-DSL_toolbar-btnTblDelete']";	
	public static String Grid_locationfield1="Grid record location field1>(//div[@col-id='location'])[2]";	
	public static String MovetoFirst="Move to First button>//button[@id='DSL-DSL_toolbar-btnTblFrist']";	
	public static String MovetoLast="MovetoLast>//button[@id='DSL-DSL_toolbar-btnTblLast']";	
	public static String MovetoNext="Move to Next button>//button[@id='DSL-DSL_toolbar-btnTblNext']";
	public static String MovetoPrevious="Move to previous button>//button[@id='DSL-DSL_toolbar-btnTblPrev']";
	public static String Deficittab="Deficittab>(//label[text()='Deficit and Surplus Location Identification'])[1]";
	public static String Close_routing="Close_routing>((//label[text()='ERO Routing'])[1]/following::a)[3]";
	
	public static String Emailinput="Yopmail email name>//*[@id='login']";
	public static String Goto_Inbox="Yopmail inbox>//button[@title='Check Inbox @yopmail.com']";
	public static String GotoMail="Yopmail email selection>((//button[@class='lm'])[2]//div)[1]";
	public static String Welcome_text="Welcome Mail text>//h2[text()='WELCOME TO FYNXT-QA']";
	
	public static String Benchmark_tab="Benchmark_tab>//label[text()='ERO Bench Mark Stock']";
	
	public static String Screen="Screen>//ul[@id='nfr_tabmdl_header']";
	public static String Fromweek_input="From year input field>//input[@id='DSL-DSL_txtFromWeek_input']";
	public static String Toweek_input="To year input field>//input[@id='DSL-DSL_txtToWeek_input']";
	public static String SurplusQty="Surplus quantity input field>//input[@id='DSL-DSL_txtSurplus']";
	public static String DeficitQty="Deficit quantity input field>//input[@id='DSL-DSL_txtDeficit']";
	public static String IDField="ID Field>//input[@id='DSL-DSL_txtID']";
	public static String Gridscroll="Grid scroller>(//div[@ref='eBodyViewport'])[1]";
	public static String Fromyear_input="From yearinput>//input[@id='DSL-DSL_spnFromYear_input']";
	public static String Toyear_input="To yearinput>//input[@id='DSL-DSL_spnToYear_input']";
	public static String fromweek_value="From week value>//input[@id='DSL-DSL_txtFromWeek_hinput']";
	public static String Toweek_value="To week value>//input[@id='DSL-DSL_txtToWeek_hinput']";
	public static String Scrollpage="Scrollpage>//*[@xmlns='http://www.w3.org/1999/xhtml']";

	public static String Closemap="Closemap>(//label[text()='Map View']/following::a)[3]";

	public static String Savepopup="Savepopup>//h2[text()='Deficit and Surplus Location Identification']/following::span[contains(text(),'save')]";
	public static String Click_ok="Click_ok>//h2[text()='Deficit and Surplus Location Identification']/following::button";
	
	public static String Jasper_popup="Jasper_popup>//*[contains(text(),'Function Not Supported')]";
	public static String Saveas_popup="Saveas_popup>(//h2[text()='Deficit and Surplus Location Identification']/following::span)[2]";

	public static String FieldDropdown="FieldDropdown>(//li[@id='DSL-DSL_tree-0']//span)[6]";
	public static String FieldDropdown_Inside="FieldDropdown_Inside field>//li[@id='DSL-DSL_tree-0_0_1']";
	public static String Verionfield="Verion field>//label[contains(text(),'Version')]";
	public static String Column1="Column1>(//div[@aria-colindex='1'])[1]";
	public static String Horizontal_gridscroll="Horizontal_gridscroll>//div[@ref='eBodyHorizontalScrollViewport']";
	
	
	public static String ColumnFilter_field="ColumnFilter field>(//div[@ref='primaryColsListPanel'])[1]";
	public static String ColumnFilter="ColumnFilter>(//span[text()='Columns'])[1]";
	public static String ColumnFilter_selectall="ColumnFilter_selectall>//input[@aria-label='Toggle Select All Columns']";
	public static String ColumnFilter_Input="ColumnFilter_Input>//input[@aria-label='Filter Columns Input']";
	public static String Tooltip="Tooltip>(//div[@id='DSL-DSL_toolbar-tblComponent']//button)[1]//span[contains(text(),'New')]";
	public static String Reposition_dropdown="Reposition dropdown>//label[@id='DSL-DSL_buttonGroup1_label']";
	public static String Question_Icon="Question Icon>(//h2[text()='Deficit and Surplus Location Identification']/following::span)[1]";
		
	public static String Show="Show>//button[@id='DSL-DSL_btnShow']";
	public static String Warningpopup_Ok="Warningpopup_Ok>//h2[text()='Deficit and Surplus Location Identification']/following::button[text()='Ok']";

	public static String Information_Icon="Information_Icon>(//*[@id='lrp_cust_growl_container']//span)[1]";
	public static String Informationpopup_message="Informationpopup_message>//*[@id='lrp_cust_growl_container']//p";
	public static String Close_Search="Globalserach Close>(//label[text()='Deficit and Surplus Location Indentification']/following::span)[1]";	 
	
	public static String Informationclose="Informationclose>//div[@class='ui-growl-icon-close ui-icon ui-icon-closethick']";
	public static String Location_filter="Location_filter>//div[@col-id='location']//span";
	public static String filterMenu="filterMenu>//div[@col-id='location']/following::span[@aria-label='filter']";
	public static String Search_input="Search_input>(//div[@col-id='location']/following::span[@aria-label='filter']/following::input)[1]";

	public static String Location1="Location1>//div[@col-id='location' and text()='CKAIT']";
	public static String Filteroption1="Filteroption1>(//div[@col-id='location'])[2]";
	public static String Filteroption2="Filteroption2>(//div[@col-id='location'])[3]";

	public static String cancel_Op="cancel_Op>//a[@id='h1_img3']";
	public static String cancel_Op1="cancel_Op1>//a[@id='h2_img3']";
	public static String cancel_Op2="cancel_Op2>//a[@id='h3_img3']";
	public static String cancel_Op3="cancel_Op3>//a[@id='h4_img3']";
	public static String New_Popup_Yes="New_Popup_Yes>//h2[text()='Deficit and Surplus Location Identification']//following::button[text()='Yes']";
	public static String Show_Popup_Yes="Show_Popup_Yes>//h2[text()='Deficit and Surplus Location Identification']//following::button[text()='Yes']";
	public static String Save_popup_ok="Save_popup_ok>//h2[text()='Deficit and Surplus Location Identification']//following::button[text()='Ok']";
	public static String Save_popup_text="Save_popup_text>(//h2[text()='Deficit and Surplus Location Identification']//following::span)[2]";

	// 213_253
	public static String New_Popup_No="New_Popup_No>//h2[text()='Deficit and Surplus Location Identification']//following::button[text()='No']";
	public static String Import="Import>//button[@id='DSL-DSL_btnImport-DSL_btnImport']";
//	public static String To_popup="To_popup>//h2[text()='Deficit and Surplus Location Identification']//following::button[text()='Yes']";
	public static String To_popup1="To_popup1>//span[text()=' Already Calculated Deficit and Surplus Counts for this Week Range and Location Hierarchy. Do you want to Calculate again?']";
	public static String No_records="No_records>//span[text()='No Records']";
	public static String No_records_ok="No_records_ok>//span[text()='No Records']//following::button[text()='Ok']";
	public static String Year_Drop_Down="Year_Drop_Down>(//*[@id='DSL-DSL_spnFromYear_input']/following::a)[2]";
	public static String Year_To_Drop_Down="Year_To_Drop_Down>(//*[@id='DSL-DSL_spnToYear_input']//following::a)[2]";
	
	public static String Toyear_Increase="Toyear_Increase>(//*[@id='DSL-DSL_spnToYear_input']//following::a)[1]";
	public static String Import_close="Import_close>(//span[@id='nfr_importxl_title']/following::a[@aria-label='Close'])[1]";

	public static String From_Year_Field="From_Year_Field>//input[@id='DSL-DSL_spnFromYear_input']";
	public static String Saved_popup="Saved_popup>//*[text()='Deficit and Surplus Location Details saved']";
	public  static String Saved_Pop3="Saved_Pop3>//span[contains(text(),'Already Calculated Deficit and Surplus Counts for this Week Range and Location Hierarchy.')]";
	public static String Saved_Yes_Option="Saved_Yes_Option>//span[contains(text(),'Already Calculated Deficit and Surplus Counts for this Week Range and Location Hierarchy.')]//following::button[text()='Yes']";
	public static String save_Conf="save_Conf>//span[text()='Deficit and Surplus Location Details saved']";
	public static String saved_Conf_Ok="saved_Conf_Ok>//span[text()='Deficit and Surplus Location Details saved']//following::button[text()='Ok']";
	public static String Map="Map>//button[@id='DSL-DSL_btnViewMap']";
	public static String Route="Route>//button[@id='DSL-DSL_btnViewPortPair']";
	public static String Click_Ok="Click_Ok>//button[text()='Ok']";
	
	public static String Map_field="Map_field>//div[@id='mapid']";
	public static String Tab1="Tab1>//label[@id='mdl1_tablbl']";
	public static String Tab2="Tab2>//label[@id='mdl2_tablbl']";
	public static String Stock_status="Stock_status>(//label[text()='Location Stock Status'])[1]";
	public static String Benchmark_Stock_status="Benchmark_Stock_status>//label[text()='ERO Bench Mark Stock']";
	public static String Location_stockstatus="Location_stockstatus>(//label[text()='Location Stock Status'])[1]";
	
	public static String Route_details="Route_details>//a[text()='Route Details']";
	
	public static String Cancel_option="((//label[text()='Deficit and Surplus Location Identification'])[1]//following::a[contains(@id,'_img3')])[2]>((//label[text()='Deficit and Surplus Location Identification'])[1]//following::a[contains(@id,'_img3')])[2]";
	public static String Total_record="Total_record>//label[@id='DSL-DSL_treeTable1_records_lbl_cnt']";

	public static String Total_columnrecord="Total_record>//label[@id='OHS-OHS_aggrid_records_lbl_cnt']";

	public static String WeeklyImbalance_label="WeeklyImbalance label>//label[@id='DSL-DSL_lblNote1']";
	public static String Appliedsurplus="Appliedsurplus>(//div[@col-id='appsurdef'])[2]";
	
	public static String Menu="Menu>//a[@id='nfr_li_ERO']";
	public static String DeficitOption="DeficitOption>//*[text()='Deficit and Surplus Location Identification']";
	public static String Stockstatustab="Stockstatustab>//*[text()='Location Stock Status']";
	public static String Locationcode_filter="Locationcode_filter>(//div[@col-id='locationcode']//span)[1]";
	public static String Locationcode_filtercolumn="Locationcode_filtercolumn>//span[@aria-label='filter']";
	public static String Filter_input="Filter_input>(//span[@aria-label='filter']/following::input)[1]";
	public static String StockstatusLocation_filter="StockstatusLocation_filter>(//label[@id='LSS-LSS_grid_records_lbl_cnt']/following::div[@col-id='locationcode']//span)[1]";

	public static String benchStockstatusLocation_filter="benchStockstatusLocation_filter>(//*[@id='EBM-EBO_treeTable1']//following::div[@col-id='location']//span)[1]";
	
	public static String Nomatches ="No matches found>//*[text()='No matches.']";
	public static String Selectall="Selectall>//span[text()='(Select All)']";
	public static String Surplus="Surplus>//span[text()='Surplus']";
	
	public static String Year_To_drop_down_Up="Year_To_drop_down_Up>(//*[@id='DSL-DSL_spnToYear_input']//following::a)[1]";
	
	//
	public static String Route_Cancel="Route_Cancel>((//label[text()='ERO Routing'])[1]//following::a[contains(@id,'_img3')])[2]";
	public static String No_record="No_record>//span[text()='No records to save']";
	public static String No_record_Ok="No_record_Ok>//button[text()='Ok']";
	public static String cancel_Op6="cancel_Op3>//a[@id='h6_img3']";
	public static String global_Close ="global_Close>(//label[text()='Deficit and Surplus Location Indentification']//following::span)[1]";
	public static String Edit_Save="Edit_Save>//b[text()='  Deficit and Surplus Location Details Updated']";
	public static String Edit_Save_Ok="Edit_Save_Ok >//b[text()='  Deficit and Surplus Location Details Updated']//following::button[text()='Ok']";
	public static String cancel_Op7="cancel_Op7>//a[@id='h8_img3']";
	public static String Refresh="Refresh>(//button[@id='DSL-DSL_btnRefresh']//span)[2]";
	public static String Refresh_pop="Refresh_pop>(//h2[text()='Deficit and Surplus Location Identification']//following::span)[2]";
	public static String Refresh_pop_no="Refresh_pop_no>//span[text()=' This will bring the refreshed data from EMS. Do you want to proceed?']//following::button[text()='No']";
	public static String Refresh_pop_Yes="Refresh_pop_Yes>//span[text()=' This will bring the refreshed data from EMS. Do you want to proceed?']//following::button[text()='Yes']";
	public static String From_week_Pop="From_week_Pop>//span[text()='From Week should not be zero']";
	public static String From_week_pop_ok="From_week_pop_ok>(//span[text()='From Week should not be zero']//following::button)[1]";
	public static String From_week_pop_ok1="From_week_pop_ok1>//button[text()='Ok']";
	public static String To_week_Pop="To_week_Pop>//span[text()='To Week should not be zero']";
	public static String To_week_Pop_ok="To_week_Pop_ok>//span[text()='To Week should not be zero']//following::button[text()='Ok']";
	public static String From_year_pop="From_year_pop>//span[text()='From Year should not be greater than To Year']";
	public static String To_week_opt="To_week_opt>//span[text()='To Week should be less than Current Week']";
	public static String Same_week_pop="Same_week_pop>//span[text()=' Already Calculated Deficit and Surplus Counts for this Week Range and Location Hierarchy. Do you want to Calculate again?']";
	public static String Same_week_pop_Yes="Same_week_pop_Yes>//button[text()='Yes']";
	public static String Same_week_pop_No="Same_week_pop_No>//button[text()='No']";
	public static String Year_drop_up_pop="Year_drop_up_pop>(//*[@id='DSL-DSL_spnFromYear_input']/following::a)[1]";
	public static String current_pop2="current_pop2>//span[text()='Difference between To and From Week Should not be greater than 52 weeks']";
//	public static String From_year_leap="From_year_leap>//input[@id='DSL-DSL_txtFromWeek_input']";
	
	
	// 213_253
	public static String To_popup="To_popup>//h2[text()='Deficit and Surplus Location Identification']//following::button[text()='Yes']";
	public static String Location="Location>(//div[@col-id='location'])[1]";
	public static String Location3="Location>(//div[@col-id='location'])[3]";
	public static String IncreaseYear="IncreaseYear>(//input[@id='DSL-DSL_spnFromYear_input']/following::span)[2]";
	public static String DecreaseYear="DecreaseYear>(//input[@id='DSL-DSL_spnFromYear_input']/following::span)[5]";
	public static String Yearwarining_popup="Yearwarining_popup>//*[text()='Validation']";
	public static String Yearwarining_popupmessage="Yearwarining_popupmessage>(//*[text()='Validation']/following::span)[3]";
	public static String Click_Okay="Click_Ok on the year warning popup>(//*[text()='Validation']/following::button)[1]";
	
	public static String Increase_ToYear="Increase_ToYear>(//input[@id='DSL-DSL_spnToYear_input']/following::span)[2]";
	public static String Decrease_ToYear="Increase_ToYear>(//input[@id='DSL-DSL_spnToYear_input']/following::span)[5]";
	
	public static String dropdown_option="dropdown_option>(//div[@id='DSL-DSL_buttonGroup1']//following::span)[1]";
	public static String Forecasting_reposition="Forecasting_reposition>//li[text()='Forecasting Reposition']";
	public static String show_yes="show_yes>//button[text()='Yes']";
	public static String surplus ="surplus>//li[text()='Surplus']"; 
	public static String Deficit="Deficit>//li[text()='Deficit']";
	public static String Neutral="Neutral>//li[text()='Neutral']";
	
	public static String Tree_table="Tree_table>//div[@id='DSL-DSL_treeTable1_nfr_toolpanel_li_id']";
	public static String Full_screen="Full screen>//img[@alt='Fullscreen']";
	public static String Export_Excel="Export_Excel>//a[@id='DSL-DSL_treeTable1_exportExcelxlsx_id']";
	public static String Saves_Template="Saves_Template>//button[@id='DSL-DSL_treeTable1_callSaveAsTemplate_id']";
	public static String Saves_Template_text="Saves_Template_text>//input[@id='DSL-DSL_treeTable1_txtTemplate']";
	public static String Save_template="Save_template>(//p[text()='Save As Template']//following::input)[2]";
	public static String Canceltemplate="Canceltemplate>(//p[text()='Save As Template']//following::input[@value='Cancel'])[1]";
	public static String Save_popup="Save_popup>//p[text()='Template Saved Successfully']";
	public static String Condition_filter="Condition_filter>//a[@id='DSL-DSL_treeTable1_conditionFilter_id']";
	public static String Distinct_filter="Distinct_filter>//a[@id='DSL-DSL_treeTable1_setDistinctFilter_id']";
	public static String filter_input="filter_input>//input[@aria-label='Location Filter Input']";
	public static String On_offhire="filter_input>//label[text()='On/Off-Hire']";
	
	public static String Saveas_tap="Tree_table>//p[text()='Save As Template']";
	
	public static String Budget_Reposition="Budget_Reposition>//li[text()='Budget Reposition']";
	
	public static String Budget="Budget>//span[@id='DSL-DSL_btnBudget_label']/ancestor::span";
	public static String EquipmentType_column2="EquipmentType_column2>(//div[@col-id='eqp'])[2]";
	public static String Import_Excel="Import_Excel>//span[@id='nfr_importxl_title']";
	
	public static String Import_page="Import_page>//div[@id='nfr_importxl']";
	public  static String col_value="col_value>((//span[text()='Location'])[1]//following::div[@col-id='location'])[1]";
	public static String Ero_ID_Field="Ero_ID_Field>//input[@id='ERU-ERU_txtID']";
	public static String Optimizer_option="Ero_ID_Field>//span[text()='Optimizer']";
	public static String ERO_Routing="ERO_Routing>//*[@id='ERU_txtFormula']";
	public static String ERO_Routing_Ok="ERO_Routing_Ok>//button[@id='ERU_btnOk']";
	public static String View_Date="View_Date>//button[@id='OPT-OPT_btnViewGate']";
	public static String ERO_Report_Gate="ERO_Report_Gate>//input[@id='ORG-ORG_txtDeficitSurplusID']";

	
	public static String Tree_record1="Tree_record1>//li[@id='DSL-DSL_tree-0']";
	public static String Tree="Tree>//div[@id='DSL-DSL_tree']";
	
	public static String TreeRegion1="Tree_Region1>(//li[@id='DSL-DSL_tree-0_0']//span)[2]";
	public static String Tree_Region1="Tree_Region1>//li[@id='DSL-DSL_tree-0_0']//span";
	
	public static String Region1_Text="Region1_Text>(//li[@id='DSL-DSL_tree-0_0']//following::span)[2]";
	public static String Region2_Text="Region2_Text>(//li[@id='DSL-DSL_tree-0_1']//following::span)[2]";
	
	public static String Country="Country>(//li[@id='DSL-DSL_tree-0_0_0']//span)[1]";
	public static String Country1_Text="Country1_Text>(//li[@id='DSL-DSL_tree-0_0_0']//following::span)[2]";
	public static String Country2_Text="Country2_Text>(//li[@id='DSL-DSL_tree-0_0_1']//following::span)[2]";
	
	
	public static String TreeLocation1="TreeLocation1>(//li[@id='DSL-DSL_tree-0_0_0']//span)[2]";
	
	public static String Tree_Location1="Tree_Location1>//li[@id='DSL-DSL_tree-0_0_0_0']";
	public static String Location1_Text="Location1_Text>(//li[@id='DSL-DSL_tree-0_0_0_0']//following::span)[2]";
	public static String Location2_Text="Location1_Text>(//li[@id='DSL-DSL_tree-0_0_0_1']//following::span)[2]";
	public static String Close_ero_routing_tab="Close_ero_routing_tab>(//label[text()='ERO Routing']/following::a)[3]";

	public static String Rulebuilder="Rulebuilder>//li[@data-item-label='ERO Rule Builder']";
	public static String Forecasting="Forecasting Rulebuilder>//span[text()='Forecasting Reposition']";

	public static String EMS_Formula="EMS_Formula>//textarea[@id='EFB-EFB_txtFormula']";
	public static String OnOFF_Hire="OnOFF_Hire>//*[@data-item-label='On Off Hire Stock Availbility']";
	public static String OnOFF_Hire_dropdown="OnOFF_Hire dropdown>//div[@id='OHS-OHS_btnhire']";
	public static String OFF_Hire_option="OFF_Hire option>//li[@id='OHS-OHS_btnhire_1']";
	public static String Hire_type="Hire_type>(//*[@col-id='hiretype']//span)[1]";
	
	public static String On_Hire="On_Hire>//span[text()='OFF HIRE']";
	public static String Off_Hire="Off_Hire>//span[text()='ON HIRE']";
	public static String delete_template="delete_template>(//i[@class='fa fa-times'])[1]";
	
	public static String DoubleClick ="DoubleClick>//div[@row-id='6']//div[@col-id='location']";
	
	public static String Status_Filter="Status_Filter>(//div[@col-id='defsurstatusflag']//span)[1]";
	public static String Benchmmark_stock="Benchmmark_stock>//li[@data-item-label='ERO Bench Mark Stock']";
	
	
	public static String Newtab_confirm="Newtab_confirm>//*[@name='nfr_launch_mdl_in_separatewindow_cnf_form']//a[text()='Yes']";
	public static String Search_module ="Search_module>//input[@id='nfr_topbar_autocomp_hinput']";

	public static String Warning_popup="Warning_popup>//label[@id='DSL_lblMsg']";
	public static String click_yes="click_yes>//button[@id='DSL_btnYes']";
	public static String To_Year_Input="To_Year_Input>//input[@id='DSL-DSL_spnToYear_input']";
	public static String SaveTemplate="SaveTemplate>(//span[text()='Save Template'])[1]";
	public static String saveTemplate_screen="saveTemplate_screen>//dialog[@id='DSL-DSL_treeTable1_templateDlg']";
	public static String SaveTemplateInput="SaveTemplateInput>//input[@id='DSL-DSL_treeTable1_txtTemplate']";
	public static String SaveTemplateCancel="SaveTemplateCancel>(//input[@value='Cancel'])[1]";
	public static String save_template="save_template>(//input[@value='Save'])[1]";
	public static String saveTemplate_popup="saveTemplate_popup>//*[text()='Template Saved Successfully']";
	public static String cancle_saveTemplate="cancle_saveTemplate>(//i[@id='_select_star']//following::i)[1]";
	public static String save_template_delete="delete_template>//p[text()='Template Deleted Successfully']";
	public static String save_template_as="save_template_as>//button[@id='DSL-DSL_treeTable1_callSaveAsTemplate_id']";
	public static String Csv_sheet="Csv_sheet>//a[@id='DSL-DSL_treeTable1_CSV_id']";
	
	public static String Budget_upload="Budget_upload>//input[@id='DSL-DSL_btnBudget_input']";
	public static String Error_ID_Search_Popup_Deficit="Error_ID_Search_Popup_Deficit>//*[@class='ui-growl-title']//following::p";
	public static String Error_ID_Search_Popup_Deficit_Invalid="Error_ID_Search_Popup_Deficit_Invalid>(//*[@class='ui-growl-title']//following::p)[1]";
	public static String Close_Button="Close_Button>(//span[@id='nfr_sch_jdlg_title']//following::a[@class='ui-dialog-titlebar-icon ui-dialog-titlebar-close ui-corner-all'])[1]";
	public static String Condition_Filter1="Condition_Filter1>(//input[@ref='eInput']//following::input[@class='ag-input-field-input ag-text-field-input'])[1]";
	public static String Condition_Filter2="Condition_Filter2>(//input[@ref='eInput']//following::input[@class='ag-input-field-input ag-text-field-input'])[2]";
	public static String Filter_verify_1="Filter_verify_1>//input[@aria-label='Location Filter Input']";
	public static String Filter_verify_2="Filter_verify_2>(//input[@aria-label='Equipment Type Filter Input']//following::div[@col-id='eqp'])[1]";
	public static String Filter_Clear="Filter_Clear>(//input[@aria-label='Location Filter Input']//following::span[@class='ag-icon ag-icon-filter'])[1]";
	public static String Reset_Filter="Reset_Filter>(//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left sm-dt-toolpanel-btn sm-dt-toolpanel-reset'])[1]";
	public static String Excel="Excel>//a[@id='DSL-DSL_treeTable1_exportExcelxlsx_id']";
	public static String CSV="Excel>//a[@id='DSL-DSL_treeTable1_CSV_id']";
	public static String Upper_Arrow1="Upper_Arrow1>(//span[@class='ui-icon ui-icon-triangle-1-n ui-c'])[1]";
	public static String Upper_Arrow2="Upper_Arrow2>(//span[@class='ui-icon ui-icon-triangle-1-n ui-c'])[2]";
	public static String Popup1="Popup1>(//h2[text()='Deficit and Surplus Location Identification']/following::span)[2]";
	public static String From_Week="From_year_leap>//input[@id='DSL-DSL_txtFromWeek_input']";
	public static String To_Week="To_Week>//input[@id='DSL-DSL_txtToWeek_input']";
	public static String Click_ok1="Click_ok1>(//h2[text()='Deficit and Surplus Location Identification']/following::button)[2]";
	public static String Export="Export>//button[@id='DSL-DSL_toolbar-btnTblDynExport']";
	public static String PDF="PDF>//button[@id='DSL-DSL_treeTable1_generateJSPDF_id']";
	public static String PDF_Design_Page="PDF_Design_Page>//div[@id='DSL-DSL_treeTable1_preview-pane']";
	public static String PDF_Close="PDF_Close>//input[@id='DSL-DSL_treeTable1_sm-aggrid-pdftempdlg-close']";
	public static String Scroll_Deficit="Scroll_Deficit>(//div[@ref='eBodyViewport'])[1]";
	public static String Excel_2007="Excel_2007>//a[@id='DSL-DSL_treeTable1_exportExcel_id']";
	public static String Location_Filter="Location_Filter>(//span[@ref='eMenu']//span)[1]";
	public static String Group_By_Loc="Group_By_Loc>//span[text()='Group by Location']";
	public static String Expand_Button="Expand_Button>(//span[@class='ag-icon ag-icon-tree-closed'])[1]";
	public static String Expand_All="Expand_All>//span[text()='Expand All']";
	public static String Expand_All_Close_Button="Expand_All_Close_Button>(//span[@class='ag-icon ag-icon-tree-open'])[1]";
	public static String Collapse_All="Collapse_All>//span[text()='Collapse All']";
	public static String Location_Tag="Location_Tag>//span[@class='ag-column-drop-cell ag-column-drop-horizontal-cell']";
	public static String Reset_All="Reset_All>//span[text()='Reset Columns']";
	public static String Multiple_Filter="Multiple_Filter>//a[@id='DSL-DSL_treeTable1_setMultipleFilter_id']";
	public static String Filter_1="Filter_1>(//span[@aria-label='filter']//span)[1]";
	public static String Multi_Filter="Multi_Filter>(//div[@col-id='value'])[2]";
	public static String Grid_locationfield_Deficit="Grid_locationfield_Deficit>(//div[@aria-colindex='1'])[2]";
	public static String Multi_Filter1="Multi_Filter1>//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-auto-height ag-cell-value']";
	public static String Full_Screen="Full_Screen>(//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left sm-dt-toolpanel-btn sm-dt-toolpanel-view'])[1]";
	public static String Columns="Columns>(//div[@ref='eIconWrapper'])[1]";
	public static String Loc_Input="Loc_Input>(//span[text()='Location'])[1]";
	public static String Loc_Checkbox="Loc_Checkbox>(//input[@ref='eInput']//following::span[text()='Location'])[2]";
	public static String Reset_Col="Reset_Col>//span[text()='Reset Columns']";
	public static String Filter_2="Filter_2>//span[@aria-label='general']";
	public static String Actual="Actual>(//div[@aria-colindex='7'])[1]";
	public static String Export_Col="Export_Col>(//div[@aria-colindex='8'])[1]";
	public static String Resize="Resize>(//div[@ref='eResize'])[1]";
	public static String Budjet_Yes="Budjet_Yes>(//span[text()='Yes'])[2]";
	public static String One_Way_Outofload="One_Way_Outofload>(//div[@aria-colindex='15'])[1]";
	public static String One_Way_Leasing="One_Way_Leasing>//span[text()='One Way Leasing']";
	public static String One_Way_Edit="One_Way_Edit>(//span[@class='ui-button-icon-left ui-icon ui-c fa fa-edit'])[2]";
	public static String One_Way_Out_Qty="One_Way_Out_Qty>//input[@id='OWL-OWL_txtOneWayQty1']";
	public static String Horizontal_gridscroll1="Horizontal_gridscroll1>(//div[@ref='eBodyHorizontalScrollViewport'])[1]";
	public static String Edit_Leasing="Edit_Leasing>//button[@id='OWL-OWS_Btnadd']";
	public static String OneWay_Leasing_Save="OneWay_Leasing_Save>(//span[@class='ui-button-icon-left ui-icon ui-c fa fa-save'])[2]";
	public static String Leasing_Updated_Popup="Leasing_Updated_Popup>(//h2[text()='One Way Leasing']/following::span)[2]";
	public static String ok_Click="ok_Click>//h2[text()='One Way Leasing']/following::button";
	public static String One_Way_In_Load="One_Way_In_Load>(//div[@aria-colindex='17'])[6]";
	public static String Lesein_Tab1="Lesein_Tab1>//span[text()='One Way Lease In']";
	public static String Lesein_Edit="Lesein_Edit>(//span[@class='ui-button-icon-left ui-icon ui-c fa fa-edit'])[6]";
	public static String One_Way_in_Qty="One_Way_in_Qty>//input[@id='OWL-OWL_txtOneWayQt']";
	public static String One_Way_Out_Return="One_Way_Out_Return>(//div[@aria-colindex='16'])[1]";
	public static String One_Way_Out_Return_Edit="One_Way_Out_Return_Edit>(//span[@class='ui-button-icon-left ui-icon ui-c fa fa-edit'])[4]";
	public static String One_Way_Leease_Out="One_Way_Leease_Out>//span[text()='One Way Lease Out']";
	public static String One_Way_in_Return_Edit="One_Way_Leease_Out>(//span[@class='ui-button-icon-left ui-icon ui-c fa fa-edit'])[5]";
	public static String One_Way_in_Return="One_Way_in_Return>(//div[@aria-colindex='19'])[2]";
	public static String Grid1_1="Grid1_1>//div[@aria-colindex='1'][1]";
	public static String Export1="Export1>(//span[text()='Export'])[3]";
	public static String Export1_Button="Export1_Button>(//span[text()='Excel Export (.xlsx)‎'])";
	public static String CSV_Export="CSV_Export>//span[text()='CSV Export']";
	public static String Weeks_Data1="Weeks_Data1>(//div[@aria-colindex='8'])[1]";
	public static String Checkbox_1="Checkbox_1>//label[@ref='eSelectAllContainer']";
	public static String Verify_Multi_Filter="Verify_Multi_Filter>(//div[@col-id='location'])[2]";
	
	public static String Close_template="Close_template>(//*[@class='fa fa-times'])[1]";
	

}


