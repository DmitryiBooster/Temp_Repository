using Microsoft.AspNetCore.Mvc;
using IsLabApp.Models;

namespace IsLabApp.Controllers;

[ApiController]
[Route("api/[controller]")]
public class NotesController : ControllerBase
{
    // Временное хранилище в памяти
    private static readonly List<Note> _notes = new();
    private static int _nextId = 1;

    // POST /api/notes
    [HttpPost]
    public IActionResult Create([FromBody] Note note)
    {
        // Простейшая валидация
        if (string.IsNullOrWhiteSpace(note.Title) || string.IsNullOrWhiteSpace(note.Text))
        {
            return BadRequest("Title and Text are required.");
        }

        note.Id = _nextId++;
        note.CreatedAt = DateTime.UtcNow;
        _notes.Add(note);

        return CreatedAtAction(nameof(GetById), new { id = note.Id }, note);
    }

    // GET /api/notes
    [HttpGet]
    public IActionResult GetAll()
    {
        return Ok(_notes);
    }

    // GET /api/notes/{id}
    [HttpGet("{id}")]
    public IActionResult GetById(int id)
    {
        var note = _notes.FirstOrDefault(n => n.Id == id);
        if (note == null)
            return NotFound();
        return Ok(note);
    }

    // DELETE /api/notes/{id}
    [HttpDelete("{id}")]
    public IActionResult Delete(int id)
    {
        var note = _notes.FirstOrDefault(n => n.Id == id);
        if (note == null)
            return NotFound();

        _notes.Remove(note);
        return NoContent();
    }
}
