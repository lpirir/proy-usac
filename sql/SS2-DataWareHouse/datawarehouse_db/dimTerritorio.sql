USE [datawarehouse]
GO
/****** Objeto:  Table [dbo].[DimTerritorio]    Fecha de la secuencia de comandos: 12/06/2008 02:01:53 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DimTerritorio](
	[TerritoryID] [int] NOT NULL,
	[Country] [nvarchar](3) COLLATE Latin1_General_BIN2 NULL,
	[Nombre] [nvarchar](50) COLLATE Latin1_General_BIN2 NULL,
 CONSTRAINT [PK_DimTerritorio] PRIMARY KEY CLUSTERED 
(
	[TerritoryID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
