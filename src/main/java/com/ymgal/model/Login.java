package com.ymgal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {
    @JsonProperty("protocol")
    public Integer ProtocolVersion = 1;
    @JsonProperty("client")
    public String ClientName;
    @JsonProperty("clientver")
    public String ClientVersion;

    public Login() {
        this.ClientName = VndbUtils.ClientName;
        this.ClientVersion = VndbUtils.ClientVersion;
    }
}
