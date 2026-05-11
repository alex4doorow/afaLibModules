package com.afa.core.dto.integrations.cdek;

import com.afa.core.utils.TextHelper;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@SuppressWarnings({"PMD.TooManyFields"})
public class CdekDeliveryPointDto {
	private String code;
    private UUID uuid;
	private String name;	
	@JsonAlias("address_comment")
	private String addressComment;
	@JsonAlias("nearest_station")
	private String nearestStation;
	@JsonAlias("work_time")
	private String workTime;
	private List<CdekPhoneDto> phones;
	private String email;
	private String note;
	private String type;
    @JsonAlias("owner_code")
    private String ownerCode;
	@JsonAlias("take_only")
    private Boolean takeOnly;
    @JsonAlias("is_handout")
    private Boolean handout;
    @JsonAlias("is_reception")
    private Boolean reception;
    @JsonAlias("is_dressing_room")
    private Boolean dressingRoom;
    @JsonAlias("is_marketplace")
    private Boolean marketPlace;
    @JsonAlias("have_cashless")
    private Boolean haveCashless;
    @JsonAlias("have_cash")
    private Boolean haveCash;
    @JsonAlias("have_fast_payment_system")
    private Boolean haveFastPaymentSystem;
    @JsonAlias("allowed_cod")
    private Boolean allowedCode;
    @JsonAlias("work_time_list")
    private List<CdekOfficeWorkTimeDto> workTimes;
    private String site;
    private CdekOfficeLocationDto location;
    @JsonAlias("weight_min")
    private Double weightMin;
    @JsonAlias("weight_max")
    private Double weightMax;
    private List<CdekOfficeCellDimensionsDto> dimensions;
    private List<CdekSystemErrorDto> errors;
    private List<CdekSystemWarningDto> warnings;

    @JsonAlias("length_max")
    private Integer lengthMax;
    @JsonAlias("width_max")
    private Double widthMax;
    @JsonAlias("height_max")
    private Double heightMax;

    public Integer getId() {
    	final String number = TextHelper.numberDigit(this.getCode());
    	if (StringUtils.isEmpty(number)) {
    		return 0;
    	}
    	return Integer.valueOf(number);
    }
    
    public String getSinglePhone() {
    	if (phones == null || phones.isEmpty()) {
    		return "";
    	}
    	return phones.getFirst().getNumber();
    }
}
