using System;
using Microsoft.Data.SqlClient;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllers();
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Чтение настроек из конфигурации
var appName = builder.Configuration["App:Name"] ?? "IsLabApp";
var appVersion = builder.Configuration["App:Version"] ?? "unknown";

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

// Закомментируем HTTPS перенаправление, чтобы избежать проблем
// app.UseHttpsRedirection();

app.UseAuthorization();
app.MapControllers();

// Диагностический эндпоинт /health
app.MapGet("/health", () =>
{
    return Results.Ok(new
    {
        status = "ok",
        time = DateTime.UtcNow.ToString("o") // формат ISO 8601
    });
});

// Эндпоинт /version
app.MapGet("/version", () =>
{
    return Results.Ok(new
    {
        name = appName,
        version = appVersion
    });
});

// ... предыдущие app.MapGet остаются ...

// Эндпоинт /db/ping
app.MapGet("/db/ping", async (IConfiguration config) =>
{
    var connectionString = config.GetConnectionString("Mssql");
    if (string.IsNullOrEmpty(connectionString))
    {
        return Results.Problem("Connection string 'Mssql' not found.");
    }

    try
    {
        await using var connection = new Microsoft.Data.SqlClient.SqlConnection(connectionString);
        await connection.OpenAsync();
        return Results.Ok(new { status = "ok", message = "Database connection successful." });
    }
    catch (Exception ex)
    {
        return Results.Problem($"Database connection failed: {ex.Message}");
    }
});

app.Run();

app.Run();
