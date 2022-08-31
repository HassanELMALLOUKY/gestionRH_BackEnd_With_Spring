package com.YadouSoft.gestionRH.Auth;

public interface SecurityParams {
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="hassanelmallouky";
    public static final long EXPIRATION=30*24*3600;
    public static final String HEADER_PREFIX="Bearer ";
}
