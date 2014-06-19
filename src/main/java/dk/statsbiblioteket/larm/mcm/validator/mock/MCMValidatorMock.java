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
			@QueryParam("objectGuids") String objectID,
			@QueryParam("includeFiles") boolean includeFiles) {
        System.out.println("Request received with parameters: [/Object_Get] " + new Date());
		System.out.println(" - sessionID   : " + sessionID + " (inserted in the Filename element)");
		System.out.println(" - objectID    : " + objectID);
		System.out.println(" - includeFiles: " + includeFiles);
		if (sessionID==null||objectID==null) {
			return "<error>" +
					"<message>An error occured. Parameters sessionGUID and objectGuids must be specified</message>" +
					"<sessionGUID>" + sessionID + "</sessionGUID>" +
					"<objectGuids>" + objectID + "</objectGuids>" +
					"<includeFiles>" + includeFiles + "</includeFiles>" +
					"</error>"; 
		}
		String returnValue;
        objectID = objectID.replaceAll("^GUID:", "");
		System.out.println("Generating return value...");
		if (sessionID.equalsIgnoreCase("invalid")) {
			returnValue = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><PortalResult Duration=\"151\"><ModuleResults><ModuleResult Fullname=\"Portal\" Duration=\"0\" Count=\"1\"><Results><Error FullName=\"Chaos.Portal.Core.Exceptions.InsufficientPermissionsException\"><Message>No folders with access</Message></Error></Results></ModuleResult></ModuleResults></PortalResult>";
		} else {
			returnValue = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><PortalResult Duration=\"745\"><ModuleResults><ModuleResult Fullname=\"Portal\" Duration=\"0\" Count=\"1\" TotalCount=\"1\"><Results><Result FullName=\"Chaos.Mcm.View.ObjectViewData\"><Id>" + objectID + "</Id><ObjectTypeId>24</ObjectTypeId><DateCreated>28-02-2013 00:28:10</DateCreated><Metadatas><Result FullName=\"Chaos.Mcm.Data.Dto.ObjectMetadata\"><Guid>15d1f40a-12c5-45ae-8438-64ffe80decf7</Guid><LanguageCode>da</LanguageCode><MetadataSchemaGuid>00000000-0000-0000-0000-0000df820000</MetadataSchemaGuid><EditingUserGuid>85a276ff-20e1-9c4b-b831-7d52ce8f495c</EditingUserGuid><MetadataXml>&lt;Larm.Program&gt;&lt;PublicationDateTime&gt;0101-01-01T00:00:00&lt;/PublicationDateTime&gt;&lt;PublicationEndDateTime&gt;0101-01-01T00:08:50&lt;/PublicationEndDateTime&gt;&lt;PublicationChannel&gt;DR P1&lt;/PublicationChannel&gt;&lt;Title&gt;Tysk propaganda-udsendelse - Reportage fra østfronten&lt;/Title&gt;&lt;Abstract /&gt;&lt;Description /&gt;&lt;Publisher /&gt;&lt;Subjects /&gt;&lt;Contributors /&gt;&lt;Creators /&gt;&lt;Locations /&gt;&lt;Identifiers&gt;&lt;DR.ProductionNumber /&gt;&lt;DR.ArchiveNumber&gt;2023&lt;/DR.ArchiveNumber&gt;&lt;SB.DomsID /&gt;&lt;/Identifiers&gt;&lt;/Larm.Program&gt;</MetadataXml><DateCreated>28-02-2013 00:28:10</DateCreated></Result><Result FullName=\"Chaos.Mcm.Data.Dto.ObjectMetadata\"><Guid>2e42e7d3-6a3e-4bb5-ae0e-fbc822344bd3</Guid><LanguageCode>da</LanguageCode><MetadataSchemaGuid>00000000-0000-0000-0000-0000dd820000</MetadataSchemaGuid><EditingUserGuid>85a276ff-20e1-9c4b-b831-7d52ce8f495c</EditingUserGuid><MetadataXml>&lt;Larm.FileInfos&gt;&lt;Larm.FileInfo&gt;&lt;StartOffSetMS&gt;0&lt;/StartOffSetMS&gt;&lt;EndOffSetMS&gt;0&lt;/EndOffSetMS&gt;&lt;FileName&gt;" + sessionID + "&lt;/FileName&gt;&lt;Index&gt;0&lt;/Index&gt;&lt;/Larm.FileInfo&gt;&lt;/Larm.FileInfos&gt;</MetadataXml><DateCreated>28-02-2013 00:28:11</DateCreated></Result><Result FullName=\"Chaos.Mcm.Data.Dto.ObjectMetadata\"><Guid>701560ec-cebf-4b1f-a58d-3cc13377b0d6</Guid><LanguageCode>da</LanguageCode><MetadataSchemaGuid>419ed517-fb13-9a46-a138-bb691f13f2ba</MetadataSchemaGuid><EditingUserGuid>85a276ff-20e1-9c4b-b831-7d52ce8f495c</EditingUserGuid><MetadataXml>&lt;Larm.Metadata&gt;&lt;Title /&gt;&lt;Description /&gt;&lt;Genre /&gt;&lt;Subjects /&gt;&lt;Tags /&gt;&lt;Note /&gt;&lt;RelatedObjects /&gt;&lt;Contributors /&gt;&lt;/Larm.Metadata&gt;</MetadataXml><DateCreated>28-02-2013 00:28:11</DateCreated></Result></Metadatas><ObjectFolders><Result FullName=\"Chaos.Mcm.Data.Dto.ObjectFolder\"><ID>1339</ID><ParentID>1338</ParentID><FolderTypeID>1</FolderTypeID><ObjectGuid>" + objectID + "</ObjectGuid><ObjectFolderTypeID>1</ObjectFolderTypeID><Name>P1</Name><DateCreated>27-02-2013 23:50:54</DateCreated></Result><Result FullName=\"Chaos.Mcm.Data.Dto.ObjectFolder\"><ID>1877</ID><ParentID>854</ParentID><FolderTypeID>1</FolderTypeID><ObjectGuid>" + objectID + "</ObjectGuid><ObjectFolderTypeID>2</ObjectFolderTypeID><Name>13</Name><DateCreated>06-03-2014 12:04:58</DateCreated></Result><Result FullName=\"Chaos.Mcm.Data.Dto.ObjectFolder\"><ID>1905</ID><ParentID>861</ParentID><FolderTypeID>1</FolderTypeID><ObjectGuid>" + objectID + "</ObjectGuid><ObjectFolderTypeID>2</ObjectFolderTypeID><Name>radioControlled</Name><DateCreated>11-03-2014 13:24:05</DateCreated></Result></ObjectFolders><ObjectRelationInfos><Result FullName=\"Chaos.Mcm.Data.Dto.ObjectRelationInfo\"><Object1Guid>" + objectID + "</Object1Guid><Object2Guid>53caf17d-8c05-4de5-be31-08e19ea94080</Object2Guid><ObjectRelationTypeID>16</ObjectRelationTypeID><Object1TypeID>24</Object1TypeID><Object2TypeID>64</Object2TypeID><ObjectRelationType>Part of</ObjectRelationType></Result><Result FullName=\"Chaos.Mcm.Data.Dto.ObjectRelationInfo\"><Object1Guid>" + objectID + "</Object1Guid><Object2Guid>657bc99c-1ee2-4c42-90e1-340906a67acb</Object2Guid><ObjectRelationTypeID>16</ObjectRelationTypeID><Object1TypeID>24</Object1TypeID><Object2TypeID>64</Object2TypeID><ObjectRelationType>Part of</ObjectRelationType></Result></ObjectRelationInfos><Files><Result FullName=\"Chaos.Mcm.Data.Dto.FileInfo\"><ID>3606432</ID><Filename>" + sessionID + "</Filename><OriginalFilename>" + sessionID + "</OriginalFilename><Token>RTMP Streaming</Token><URL>rtmp://130.225.250.44:1935/chaos_non/mp3:/Kulturarv_MP3/DRArchive/Allans/P1/" + sessionID + "</URL><FormatID>49</FormatID><FormatCategory>LARM</FormatCategory><FormatType>Audio</FormatType></Result><Result FullName=\"Chaos.Mcm.Data.Dto.FileInfo\"><ID>3606433</ID><Filename>P1_logo.png</Filename><OriginalFilename>P1_logo.png</OriginalFilename><Token>HTTP Download</Token><URL>http://s3-eu-west-1.amazonaws.com/mcm/LarmLogos/P1_logo.png</URL><FormatID>50</FormatID><FormatCategory>Thumbnail</FormatCategory><FormatType>Image</FormatType></Result></Files><AccessPoints><Result FullName=\"Chaos.Mcm.Data.Dto.ObjectAccessPoint\"><AccessPointGuid>00000000-0000-0000-0000-000007000000</AccessPointGuid><ObjectGuid>" + objectID + "</ObjectGuid><StartDate>03-11-2013 09:47:18</StartDate><DateCreated>06-11-2013 09:47:20</DateCreated></Result></AccessPoints></Result></Results></ModuleResult></ModuleResults></PortalResult>";
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
