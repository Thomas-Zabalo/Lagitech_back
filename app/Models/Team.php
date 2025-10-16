<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Team extends Model
{
    use HasFactory;

    protected $fillable = [
        'nom',
    ];

   // Une équipe peut avoir plusieurs utilisateurs
    public function users()
    {
        return $this->hasMany(User::class, 'team_id');
    }

    // Une équipe peut être dans plusieurs matchs
    public function matchesAsEquipe1()
    {
        return $this->hasMany(Matches::class, 'id_equipe_1');
    }

    // Une équipe peut être dans plusieurs matchs
    public function matchesAsEquipe2()
    {
        return $this->hasMany(Matches::class, 'id_equipe_2');
    }

    // Une équipe peut marquer plusieurs buts
    public function goals()
    {
        return $this->hasMany(Goal::class, 'id_equipe');
    }
}
