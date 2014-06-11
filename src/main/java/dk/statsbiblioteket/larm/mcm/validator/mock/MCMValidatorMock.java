package dk.statsbiblioteket.larm.mcm.validator.mock;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/Object")
public class MCMValidatorMock {

    // Path /Object/Get
    @Path("/Get")
	// The Java method will process HTTP GET requests
    @GET
	// The Java method will produce content identified by the MIME Media
	// type "text/plain"
	@Produces("text/xml")
	public String getMCMRetunValue(
			@QueryParam("sessionGUID") String sessionID,
			@QueryParam("query") String objectID,
			@QueryParam("includeFiles") boolean includeFiles) {
        System.out.println("Request received with parameters: [/Object_Get] " + new Date());
		System.out.println(" - sessionID   : " + sessionID + " (inserted in the Filename element)");
		System.out.println(" - objectID    : " + objectID);
		System.out.println(" - includeFiles: " + includeFiles);
		if (sessionID==null||objectID==null) {
			return "<error>" +
					"<message>An error occured. Parameters sessionID and objectID must be specified</message>" +
					"<sessionID>" + sessionID + "</sessionID>" +
					"<objectID>" + objectID + "</objectID>" +
					"<includeFiles>" + includeFiles + "</includeFiles>" +
					"</error>"; 
		}
		String returnValue;
        objectID = objectID.replaceAll("^GUID:", "");
		System.out.println("Generating return value...");
		if (sessionID.equalsIgnoreCase("invalid")) {
			returnValue = "<Exception>" +
								"<Message>The SessionID is not valid</Message>" +
								"<Fullname>Geckon.Security.Web.SessionNotAuthenticatedException</Fullname>" +
								"<Stacktrace>" +
									"at Geckon.Portal.Web.Service.PortalServiceBase.GetUserInfo(UserInfo userInfo, Products productFlags) in C:\\Geckon\\Repository\\Active\\Geckon.Portal\\trunk\\src\\app\\Geckon.Portal.Web.Service\\PortalServiceBase.cs:line 107&#xD;" +
									"at Geckon.Portal.Web.Service.PortalServiceBase.GetUserInfo(String sessionID, Products productFlags) in C:\\Geckon\\Repository\\Active\\Geckon.Portal\\trunk\\src\\app\\Geckon.Portal.Web.Service\\PortalServiceBase.cs:line 126&#xD;" +
									"at Geckon.Portal.Web.Service.PortalService.Object_Get(String sessionID, String query, String sort, Nullable`1 pageSize, Nullable`1 pageIndex, Nullable`1 includeFiles, Nullable`1 includeMetadata, Nullable`1 includePublishSettings, Nullable`1 includeRelations, Int32[] channelID, Int32[] objectID, Nullable`1 objectTypeID, Nullable`1 folderID, Nullable`1 metadataSchemaID, Int32[] metadataLanguageIDs, String metadataFreeTextQuery) in C:\\Geckon\\Repository\\Active\\Geckon.Portal\\trunk\\src\\app\\Geckon.Portal.Web.Service\\PortalService.cs:line 278&#xD;" +
									"at SyncInvokeObject_Get(Object , Object[] , Object[] )&#xD;" +
									"at System.ServiceModel.Dispatcher.SyncMethodInvoker.Invoke(Object instance, Object[] inputs, Object[]&amp; outputs)&#xD;" +
									"at System.ServiceModel.Dispatcher.DispatchOperationRuntime.InvokeBegin(MessageRpc&amp; rpc)&#xD;" +
									"at System.ServiceModel.Dispatcher.ImmutableDispatchRuntime.ProcessMessage5(MessageRpc&amp; rpc)&#xD;" +
									"at System.ServiceModel.Dispatcher.ImmutableDispatchRuntime.ProcessMessage31(MessageRpc&amp; rpc)&#xD;" +
									"at System.ServiceModel.Dispatcher.MessageRpc.Process(Boolean isOperationContextSet)" +
								"</Stacktrace>" +
							"</Exception>";
		} else {
			returnValue = "<?xml version=\"1.0\"?>\n"
                    + "<PortalResult Duration=\"1324\">\n"
                    + "    <ModuleResults>\n"
                    + "        <ModuleResult Fullname=\"MCM\" Duration=\"1308\" Count=\"1\" TotalCount=\"1\">\n"
                    + "            <Results>\n"
                    + "                <Result FullName=\"CHAOS.MCM.Data.DTO.Object\">\n"
                    + "                    <GUID>" + objectID + "</GUID>\n"
                    + "                    <ObjectTypeID>40</ObjectTypeID>\n"
                    + "                    <DateCreated>13-06-2012 19:44:22</DateCreated>\n"
                    + "                    <Metadatas/>\n"
                    + "                    <Files>\n"
                    + "                        <Result FullName=\"CHAOS.MCM.Data.DTO.FileInfo\">\n"
                    + "                            <ID>27900</ID>\n"
                    + "                            <Filename>" + sessionID + "</Filename>\n"
                    + "                            <OriginalFilename>P3_2000_2200_890622_001.mp3</OriginalFilename>\n"
                    + "                            <Token>RTMP Streaming</Token>\n"
                    + "                            <URL>\n"
                    + "                                rtmp://streaming.chaos.larm-archive.org/chaos_non/mp3:Kulturarv_MP3/Batch04/Disc11/mp3_128kbps/P3_2000_2200_890622_001.mp3\n"
                    + "                            </URL>\n"
                    + "                            <FormatID>6</FormatID>\n"
                    + "                            <Format>MP3 128 kbit CBR</Format>\n"
                    + "                            <FormatCategory>Audio Preview</FormatCategory>\n"
                    + "                            <FormatType>Audio</FormatType>\n"
                    + "                        </Result>\n"
                    + "                        <Result FullName=\"CHAOS.MCM.Data.DTO.FileInfo\">\n"
                    + "                            <ID>50007</ID>\n"
                    + "                            <Filename>P3_logo.png</Filename>\n"
                    + "                            <OriginalFilename>P3_logo.png</OriginalFilename>\n"
                    + "                            <Token>HTTP Download</Token>\n"
                    + "                            <URL>http://s3-eu-west-1.amazonaws.com/mcm/LarmLogos/P3_logo.png</URL>\n"
                    + "                            <FormatID>5</FormatID>\n"
                    + "                            <Format>PNG</Format>\n"
                    + "                            <FormatCategory>Thumbnail</FormatCategory>\n"
                    + "                            <FormatType>Image</FormatType>\n"
                    + "                        </Result>\n"
                    + "                    </Files>\n"
                    + "                    <ObjectRelations/>\n"
                    + "                </Result>\n"
                    + "            </Results>\n"
                    + "        </ModuleResult>\n"
                    + "    </ModuleResults>\n"
                    + "</PortalResult>";
		}
		System.out.println("Return value generated: \n" + returnValue);

		/*
		String filename = "cachedReturnValue.xml";
		File file = new File(filename);
		try {
			byte[] buffer = new byte[(int) file.length()];
			BufferedInputStream f = null;
			try {
				InputStream is = new FileInputStream(file);
				f = new BufferedInputStream(is);
				f.read(buffer);
			} finally {
				if (f != null)
					f.close();
			}
		    returnValue = new String(buffer);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			returnValue = "<error>" +
							"<message>An error occured. Could not find filename: " + file.getAbsolutePath() + "</message>" +
							"<sessionID>" + sessionID + "</sessionID>" +
							"<objectID>" + objectID + "</objectID>" +
							"<includeFiles>" + includeFiles + "</includeFiles>" +
							"</error>"; 
		} 
		*/
	    return returnValue;
	 }
}
