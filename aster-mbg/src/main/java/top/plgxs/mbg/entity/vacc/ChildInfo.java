package top.plgxs.mbg.entity.vacc;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *  个案信息-用来测试分库分表
 * </p>
 *
 * @author Stranger.
 * @since 2021-08-02
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("c_child_info")
@ApiModel(value="ChildInfo对象", description="")
public class ChildInfo extends Model<ChildInfo> {

    private static final long serialVersionUID = 1L;

    @TableId("child_id")
    private String childId;

    @TableField("name")
    private String name;

    @TableField("code")
    private String code;

    @TableField("idcard_type")
    private Integer idcardType;

    @TableField("idcard_no")
    private String idcardNo;

    @TableField("birth_card_no")
    private String birthCardNo;

    @TableField("gender")
    private String gender;

    @TableField("country_code")
    private String countryCode;

    @TableField("birth_date")
    private String birthDate;

    @TableField("birth_time")
    private String birthTime;

    @TableField("birth_hospital")
    private String birthHospital;

    @TableField("parity")
    private BigDecimal parity;

    @TableField("race")
    private String race;

    @TableField("birth_weight")
    private BigDecimal birthWeight;

    @TableField("live_address")
    private String liveAddress;

    @TableField("nationality_code")
    private String nationalityCode;

    @TableField("household_property")
    private String householdProperty;

    @TableField("household_type")
    private String householdType;

    @TableField("family_phone")
    private String familyPhone;

    @TableField("shot_message_mark")
    private String shotMessageMark;

    @TableField("shot_message_time")
    private String shotMessageTime;

    @TableField("father_name")
    private String fatherName;

    @TableField("father_card_type")
    private String fatherCardType;

    @TableField("father_idcard")
    private String fatherIdcard;

    @TableField("father_phone")
    private String fatherPhone;

    @TableField("father_workplace")
    private String fatherWorkplace;

    @TableField("mother_name")
    private String motherName;

    @TableField("mother_card_type")
    private String motherCardType;

    @TableField("mother_idcard")
    private String motherIdcard;

    @TableField("mother_phone")
    private String motherPhone;

    @TableField("mother_workplace")
    private String motherWorkplace;

    @TableField("mother_hb")
    private String motherHb;

    @TableField("contraindication_mark")
    private String contraindicationMark;

    @TableField("contraindication")
    private String contraindication;

    @TableField("infectious_his_mark")
    private String infectiousHisMark;

    @TableField("infectious_his")
    private String infectiousHis;

    @TableField("allergy_his_mark")
    private String allergyHisMark;

    @TableField("allergy_his")
    private String allergyHis;

    @TableField("aefi_his_mark")
    private String aefiHisMark;

    @TableField("aefi_his")
    private String aefiHis;

    @TableField("record_status")
    private String recordStatus;

    @TableField("record_date")
    private String recordDate;

    @TableField("record_area_id")
    private String recordAreaId;

    @TableField("record_organ_code")
    private String recordOrganCode;

    @TableField("record_organ_name")
    private String recordOrganName;

    @TableField("create_date")
    private String createDate;

    @TableField("create_area_code")
    private String createAreaCode;

    @TableField("create_org_code")
    private String createOrgCode;

    @TableField("creator")
    private String creator;

    @TableField("bar_code")
    private String barCode;

    @TableField("insurcode")
    private String insurcode;

    @TableField("healthc_code")
    private String healthcCode;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("info_integrity_mark")
    private String infoIntegrityMark;

    @TableField("last_update_time")
    private LocalDateTime lastUpdateTime;

    @TableField("last_update_person")
    private String lastUpdatePerson;

    @TableField("last_update_person_name")
    private String lastUpdatePersonName;

    @TableField("last_update_org")
    private String lastUpdateOrg;

    @TableField("input_time")
    private LocalDateTime inputTime;

    @TableField("inputer")
    private String inputer;

    @TableField("inputer_name")
    private String inputerName;

    @TableField("input_org_code")
    private String inputOrgCode;

    @TableField("status")
    private String status;

    @TableField("data_source")
    private String dataSource;

    @TableField("province_id")
    private BigDecimal provinceId;

    @TableField("guardian")
    private String guardian;

    @TableField("all_integrity_mark")
    private String allIntegrityMark;

    @TableField("merge_child_id")
    private String mergeChildId;

    @TableField("create_organ")
    private String createOrgan;

    @TableField("client_mark")
    private String clientMark;

    @TableField("family_mobile")
    private String familyMobile;

    @TableField("case_version")
    private String caseVersion;

    @TableField("live_areaid")
    private String liveAreaid;

    @TableField("live_town")
    private String liveTown;

    @TableField("last_vaccination_time")
    private String lastVaccinationTime;

    @TableField("remark")
    private String remark;

    @TableField("case_type")
    private String caseType;

    @TableField("is_should_vacc")
    private String isShouldVacc;

    @TableField("relation_ship")
    private String relationShip;

    @TableField("whether_merge")
    private String whetherMerge;

    @TableField("is_migrate")
    private String isMigrate;

    @TableField("wechat_id")
    private String wechatId;

    @TableField("school_id")
    private String schoolId;

    @TableField("kindergarten_id")
    private String kindergartenId;

    @TableField("hiv_mark")
    private String hivMark;

    @TableField("avoid_vaccine")
    private String avoidVaccine;

    @TableField("avoid_vaccine_reason")
    private String avoidVaccineReason;

    @TableField("app_id")
    private String appId;

    @TableField("mun_barcode_decrypt")
    private String munBarcodeDecrypt;

    @TableField("mun_barcode_encryption")
    private String munBarcodeEncryption;

    @TableField("wechat_id2")
    private String wechatId2;

    @TableField("wechat_id3")
    private String wechatId3;

    @TableField("wechat_id4")
    private String wechatId4;

    @TableField("is_abortion")
    private String isAbortion;

    @TableField("nationality_address")
    private String nationalityAddress;

    @TableField("mother_race")
    private String motherRace;

    @TableField("father_race")
    private String fatherRace;

    @TableField("father_hb")
    private String fatherHb;

    @TableField("junior_school_id")
    private String juniorSchoolId;

    @TableField("school_year")
    private String schoolYear;

    @TableField("kindergarten_year")
    private String kindergartenYear;

    @TableField("junior_year")
    private String juniorYear;

    @TableField("school_class")
    private String schoolClass;

    @TableField("kindergarten_class")
    private String kindergartenClass;

    @TableField("junior_class")
    private String juniorClass;

    @TableField("data_type")
    private String dataType;

    @TableField("obstetric_code")
    private String obstetricCode;

    @TableField("quik_short_name")
    private String quikShortName;

    @TableField("immu_record")
    private String immuRecord;

    @TableField("father_hbega")
    private String fatherHbega;

    @TableField("mother_hbega")
    private String motherHbega;

    @TableField("gestation_age")
    private String gestationAge;

    @TableField("work_space")
    private String workSpace;

    @TableField("occupation")
    private String occupation;


    @Override
    protected Serializable pkVal() {
        return this.childId;
    }

}
