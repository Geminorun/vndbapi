package com.ymgal;

public class Constants {
    //          Dump info  .
    public static final String TagsDump = "https://vndb.org/api/tags.json.gz";
    public final char EotChar = '\u0004';
    public final String ApiDomain = "api.vndb.org";
    public final Integer ApiPort = 19534;
    public final Integer ApiPortTls = 19535;
    public final String TraitsDump = "https://vndb.org/api/traits.json.gz";
    public final String VotesDump = "https://vndb.org/api/votes.gz";
    public final String VotesDump2 = "https://vndb.org/api/votes2.gz";


    //          Misc commands  .
    public final String LoginCommand = "login";
    public final String DbStatsCommand = "dbstats";


    //          Get commands  .
    public final String GetVisualNovelCommand = "get vn";
    public final String GetReleaseCommand = "get release";
    public final String GetProducerCommand = "get producer";
    public final String GetCharacterCommand = "get character";
    public final String GetUserCommand = "get user";
    public final String GetVotelistCommand = "get votelist";
    public final String GetVisualNovelListCommand = "get vnlist";
    public final String GetWishlistCommand = "get wishlist";
    public final String GetUserListCommand = "get ulist";
    public final String GetUserListLabelsCommand = "get ulist-labels";
    public final String GetStaffCommand = "get staff";


    //          Set commands  .
    public final String SetVotelistCommand = "set votelist";
    public final String SetVisualNovelListCommand = "set vnlist";
    public final String SetWishlistCommand = "set wishlist";
    public final String SetUserListCommand = "set ulist";


    // Result values  .
    public final String Results = "results";
    public final String DbStats = "dbstats"; // Yes, this is identical to DbStatsCommand.
    public final String Error = "error";
    public final String Ok = "ok";

}

