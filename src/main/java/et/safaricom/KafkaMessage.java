package et.safaricom;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KafkaMessage {
    @JsonProperty("iccid")
    private String iccid;

    @JsonProperty("msisdn")
    private String msisdn;

    @JsonProperty("imsi")
    private String imsi;

    @JsonProperty("timestamp")
    private String timeStamp;

    @JsonProperty("ProfileType")
    private String profileType;

    @JsonProperty("customerFullName")
    private String CustomerFullName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("language")
    private String language;

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("dob")
    private String dob;

    @JsonProperty("localDob")
    private String localDob;

    @JsonProperty("activationType")
    private String activationType;

    @JsonProperty("customerStatus")
    private String customerStatus;
    @JsonProperty("customerID")
    private String customerId;

    @JsonProperty("reg_document_type")
    private String reg_document_type;

    @JsonProperty("reg_document_number")
    private String reg_document_number;
    @JsonProperty("created_user")
    private String created_user;

    @JsonProperty("document_issue_Date")
    private String documentIssueDate;

    @JsonProperty("isMinor")
    private String isMinor;

    @JsonProperty("Occupation")
    private String Occupation;

    @JsonProperty("Employer")
    private String Employer;

    @JsonProperty("Position")
    private String Position;

    @JsonProperty("Averagemonthlyincome")
    private String AverageMonthly_income;
    @JsonProperty("IDExpiryDate")
    private String idExpiryDate;

    @JsonProperty("StatusFlag")
    private String StatusFlag;

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDocumentIssueDate() {
        return documentIssueDate;
    }

    public void setDocumentIssueDate(String documentIssueDate) {
        this.documentIssueDate = documentIssueDate;
    }

    public String getIdExpiryDate() {
        return idExpiryDate;
    }

    public void setIdExpiryDate(String idExpiryDate) {
        this.idExpiryDate = idExpiryDate;
    }

    @Override
    public String toString() {
        return String.format("""
                KafkaMessage = {
                    iccid: %s,
                    msisdn: %s,
                    imsi: %s,
                    timeStamp: %s,
                    ProfileType: %s,
                    customerFullName: %s,
                    email: %s,
                    language:  %s,
                    nationality: %s,
                    channel:  %s,
                    dob:  %s,
                    localDob:  %s,
                    activationType:  %s,
                    customerStatus:  %s,
                    customerID:  %s,
                    reg_document_type: %s,
                   	reg_document_number: %s,
                    created_user:  %s,
                    document_issue_Date:  %s,
                    isMinor: %s,
                    Occupation: %s,
                    Employer:  %s,
                    Position:  %s,
                    Averagemonthlyincome:  %s,
                    IDExpiryDate:  %s,
                    StatusFlag: %s
                }
                """, iccid, msisdn, imsi, timeStamp, profileType, CustomerFullName, email, language, nationality,
                channel,
                dob,
                localDob,
                activationType,
                customerStatus,
                customerId,
                reg_document_type,
                reg_document_number,
                created_user,
                documentIssueDate,
                isMinor,
                Occupation,
                Employer,
                Position,
                AverageMonthly_income,
                idExpiryDate,
                StatusFlag);
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    public String getCustomerFullName() {
        return CustomerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        CustomerFullName = customerFullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLocalDob() {
        return localDob;
    }

    public void setLocalDob(String localDob) {
        this.localDob = localDob;
    }

    public String getActivationType() {
        return activationType;
    }

    public void setActivationType(String activationType) {
        this.activationType = activationType;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCreated_user() {
        return created_user;
    }

    public void setCreated_user(String created_user) {
        this.created_user = created_user;
    }

    public String getIsMinor() {
        return isMinor;
    }

    public void setIsMinor(String isMinor) {
        this.isMinor = isMinor;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getEmployer() {
        return Employer;
    }

    public void setEmployer(String employer) {
        Employer = employer;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getAverageMonthly_income() {
        return AverageMonthly_income;
    }

    public void setAverageMonthly_income(String averageMonthly_income) {
        AverageMonthly_income = averageMonthly_income;
    }

    public String getStatusFlag() {
        return StatusFlag;
    }

    public void setStatusFlag(String statusFlag) {
        StatusFlag = statusFlag;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getReg_document_type() {
        return reg_document_type;
    }

    public void setReg_document_type(String reg_document_type) {
        this.reg_document_type = reg_document_type;
    }

    public String getReg_document_number() {
        return reg_document_number;
    }

    public void setReg_document_number(String reg_document_number) {
        this.reg_document_number = reg_document_number;
    }
}
